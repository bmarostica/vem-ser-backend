package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.LoginDTO;
import com.dbc.pessoaapi.dto.UsuarioCreateDTO;
import com.dbc.pessoaapi.dto.UsuarioDTO;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.security.TokenService;
import com.dbc.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) throws RegraDeNegocioException {
        UsernamePasswordAuthenticationToken user =
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsuario(),
                        loginDTO.getSenha()
                );

        Authentication authentication = authenticationManager.authenticate(user);

        String token = tokenService.getToken((UsuarioEntity) authentication.getPrincipal());

        return token;
    }

    @PostMapping("/create")
    public UsuarioDTO postUsuario(@RequestBody UsuarioCreateDTO usuarioCreateDTO){
        return usuarioService.create(usuarioCreateDTO);
    }
}
