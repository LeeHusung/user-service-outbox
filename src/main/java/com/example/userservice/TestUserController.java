//package com.example.userservice;
//
//import com.example.userservice.client.OrderServiceClient;
//import com.example.userservice.dto.UserDto;
//import com.example.userservice.jpa.UserEntity;
//import com.example.userservice.service.UserService;
//import com.example.userservice.vo.ResponseOrder;
//import com.example.userservice.vo.ResponseUser;
//import feign.FeignException;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//@RestController
//@Slf4j
//public class TestUserController {
//
//    private final OrderServiceClient orderServiceClient;
//    private final UserService userService;
//
//    public TestUserController(OrderServiceClient orderServiceClient, UserService userService) {
//        this.orderServiceClient = orderServiceClient;
//        this.userService = userService;
//    }
//
//    @GetMapping("/users")
//    public ResponseEntity<List<UserDto>> getUsers(@PageableDefault Pageable pageable) {
//        //10명의 회원 가져온다고 가정.
//        Iterable<UserEntity> userList = userService.getUserByAll(pageable);
//        List<UserDto> result = new ArrayList<>();
//        for (UserEntity userEntity : userList) {
//            UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);
//            List<ResponseOrder> ordersList = null;
//            try {
//                //Feign 을 이용한 order 정보 조회
//                ordersList = orderServiceClient.getOrders(userEntity.getUserId());
//            } catch (FeignException e) {
//                log.error(e.getMessage());
//            }
//            userDto.setOrders(ordersList);
//            result.add(userDto);
//        }
//
////        final List<String> temp = List.of("test1", "test2", "test3", "test4");
////
////        temp.stream()
////                .map(t -> {
////                    System.out.println("111111");
////                    return "test";
////                })
////                .filter(t -> "test1".equals(t))
////                .peek(t -> System.out.println("22222"))
////                .forEach(t -> System.out.println("333333"));
//        return ResponseEntity.ok(result);
//    }
//
////    @GetMapping("/users")
////    public ResponseEntity<List<UserDto>> getUsersWithBatch(@PageableDefault Pageable pageable) {
////        List<Integer> userIds = userService.getUserByAllBatch(pageable);
////        Map<Integer, List<ResponseUser>> ordersList = orderServiceClient.getOrdersBatch(userIds);
////
////        //이후 user와 order 조합하여 반환
////        return ResponseEntity.ok(result);
////    }
//}
