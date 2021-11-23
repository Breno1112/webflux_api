package com.breno.AsyncAPIDemo.mappers;

import com.breno.AsyncAPIDemo.domain.mongo.entities.UserMongoEntity;
import com.breno.AsyncAPIDemo.domain.redis.entities.UserRedisEntity;
import com.breno.AsyncAPIDemo.dtos.request.UserRequestDTO;
import com.breno.AsyncAPIDemo.dtos.response.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDTO fromRedisEntityToDTO(UserRedisEntity userRedisEntity){
        final UserResponseDTO response = new UserResponseDTO();
        if (userRedisEntity != null){
            response.setId(userRedisEntity.getId());
            response.setIdade(userRedisEntity.getIdade());
            response.setNome(userRedisEntity.getNome());
        }
        return response;
    }

    public UserRedisEntity fromDTOToEntity(UserRequestDTO request){
        final UserRedisEntity userRedisEntity = new UserRedisEntity();
        if(request != null){
            userRedisEntity.setNome(request.getNome());
            userRedisEntity.setIdade(request.getIdade());
        }
        return userRedisEntity;
    }

    public UserResponseDTO fromMongoEntityToDTO(UserMongoEntity userMongoEntity){
        final UserResponseDTO responseDTO = new UserResponseDTO();
        if(userMongoEntity != null){
            responseDTO.setId(userMongoEntity.getId());
            responseDTO.setNome(userMongoEntity.getNome());
            responseDTO.setIdade(userMongoEntity.getIdade());
        }
        return responseDTO;
    }

    public UserMongoEntity fromDTOToMongoEntity(UserRequestDTO dto){
        final UserMongoEntity userMongoEntity = new UserMongoEntity();
        if(dto != null){
            userMongoEntity.setNome(dto.getNome());
            userMongoEntity.setIdade(dto.getIdade());
        }
        return userMongoEntity;
    }

}
