package com.breno.AsyncAPIDemo.services;

import com.breno.AsyncAPIDemo.domain.mongo.repositories.UserMongoRepository;
import com.breno.AsyncAPIDemo.domain.redis.entities.UserRedisEntity;
import com.breno.AsyncAPIDemo.domain.redis.repositories.UserRedisRepository;
import com.breno.AsyncAPIDemo.dtos.request.UserRequestDTO;
import com.breno.AsyncAPIDemo.dtos.response.MainResponseDTO;
import com.breno.AsyncAPIDemo.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserRedisRepository userRedisRepository;

    @Autowired
    private UserMongoRepository userMongoRepository;

    private static final String CREATED_SUCCESSFULLY = "User created successfully!";
    private static final String USER_FOUND = "User foud!";
    private static final String USER_NOT_FOUND = "User not found!";

    public MainResponseDTO addUserToRedis(UserRequestDTO request){
        final MainResponseDTO response = new MainResponseDTO();
        response.setData(this.mapper.fromRedisEntityToDTO(this.userRedisRepository.save(this.mapper.fromDTOToEntity(request))));
        response.setStatus(HttpStatus.CREATED);
        response.setMessage(CREATED_SUCCESSFULLY);
        return response;
    }

    public MainResponseDTO getUserFromRedis(String id){
        final MainResponseDTO response = new MainResponseDTO();
        final Optional<UserRedisEntity> optionalUser = this.userRedisRepository.findById(id);
        if (optionalUser.isPresent()){
            response.setData(this.mapper.fromRedisEntityToDTO(optionalUser.get()));
            response.setStatus(HttpStatus.OK);
            response.setMessage(USER_FOUND);
        } else {
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage(USER_NOT_FOUND);
        }
        return response;
    }

    public MainResponseDTO createUserOnMongo(UserRequestDTO request){
        final MainResponseDTO responseDTO = new MainResponseDTO();
        responseDTO.setData(this.mapper.fromMongoEntityToDTO(this.userMongoRepository.save(this.mapper.fromDTOToMongoEntity(request))));
        responseDTO.setMessage(CREATED_SUCCESSFULLY);
        responseDTO.setStatus(HttpStatus.CREATED);
        return responseDTO;
    }
}
