package com.greta.federation.config;

import com.greta.federation.services.auth.ApplicationUserDetailsService;
import com.greta.federation.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ApplicationRequestFilter extends OncePerRequestFilter {

    // Injection de la classe utilitaire pour les JWTs
    @Autowired
    private JwtUtil jwtUtil;

    // Injection de notre service personnalisé pour les détails des utilisateurs
    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    // Cette méthode est appelée pour chaque requête passant par le filtre
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // Récupération de l'en-tête Authorization de la requête
        final String authHeader = request.getHeader("Authorization");
        String userEmail = null;
        String jwt = null;

        // Si l'en-tête Authorization n'est pas null et commence par Bearer, extrait le JWT
        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            userEmail = jwtUtil.extractUsername(jwt);
        }

        // Si l'email de l'utilisateur n'est pas null et qu'aucune authentification n'est présente dans le contexte de sécurité,
        // le code charge les détails de l'utilisateur
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);

            // Si le token JWT est valide, crée un UsernamePasswordAuthenticationToken et le place dans le contexte de sécurité
            if (jwtUtil.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        // Passe la requête au prochain filtre dans la chaîne
        chain.doFilter(request, response);
    }
}
