package com.breno.AsyncAPIDemo.controllers;

import com.breno.AsyncAPIDemo.dtos.request.UserRequestDTO;
import com.breno.AsyncAPIDemo.dtos.response.MainResponseDTO;
import com.breno.AsyncAPIDemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}/hello")
    public Flux<String> helloUser(@PathVariable("username") String username){
        return Flux.just(String.format("Hello %s!", username));
    }

    @PostMapping("/redis")
    public Flux<MainResponseDTO> addUserToRedis(@RequestBody UserRequestDTO body, ServerHttpResponse response){
        final MainResponseDTO responseDTO = userService.addUserToRedis(body);
        response.setStatusCode(responseDTO.getStatus());
        return Flux.just(responseDTO);
    }

    @GetMapping("/redis/{id}")
    public Flux<MainResponseDTO> getUserFromRedis(@PathVariable("id") String id, ServerHttpResponse response){
        final MainResponseDTO responseDTO = userService.getUserFromRedis(id);
        response.setStatusCode(responseDTO.getStatus());
        return Flux.just(responseDTO);
    }

    @PostMapping("/mongodb")
    public Flux<MainResponseDTO> createUserOnMongo(@RequestBody UserRequestDTO userRequestDTO, ServerHttpResponse response){
        final MainResponseDTO responseDTO = this.userService.createUserOnMongo(userRequestDTO);
        response.setStatusCode(responseDTO.getStatus());
        return Flux.just(responseDTO);
    }
}
