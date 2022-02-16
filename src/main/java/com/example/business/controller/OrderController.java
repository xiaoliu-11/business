package com.example.business.controller;


import com.example.business.entity.UserOrderPO;
import com.example.business.service.UserOrderPOService;
import com.example.business.vo.order.UserOrderVO;
import com.example.business.vo.response.ServerResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("订单接口模块")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserOrderPOService userOrderPOService;

    @ApiOperation(value = "根据id查询用户订单")
    @PostMapping("/{id}")
    public UserOrderPO getUserOrderById(@PathVariable("id") int id) {
        return userOrderPOService.getById(id);
    }

    @ApiOperation(value = "查询所有订单")
    @PostMapping("/orderall")
    public List<UserOrderPO> listOrder() {
        return userOrderPOService.list();
    }

    @ApiOperation(value = "分页查询订单")
    @PostMapping("/orderpage/{current}/{size}")
    public ServerResponseVO<UserOrderPO> getUserOrderPage(@PathVariable("current") int current,
                                              @PathVariable("size") int size) {
        return ServerResponseVO.success(userOrderPOService.getUserOrderPage(current, size));

    }


    @ApiOperation(value = "添加或者修改订单")
    @PostMapping("/save")
    public ServerResponseVO<?> saveOrder(@RequestBody UserOrderVO userOrderVO) {
        return ServerResponseVO.success(userOrderPOService.saveOrUpdateOrder(userOrderVO));
    }



    @ApiOperation(value = "通过统一返回的接口查询所有订单")
    @PostMapping("/orderalltwo")
   public ServerResponseVO<UserOrderPO> listUserOrder(){
        return ServerResponseVO.success(userOrderPOService.list());

   }

    @ApiOperation(value = "根据id删除订单")
    @PostMapping("/deleteOrder/{id}")
    public ServerResponseVO<?> deleteOrderById(@PathVariable("id") int id){
        return ServerResponseVO.success(userOrderPOService.removeById(id));

    }

    @ApiOperation(value = "根据【用户名】查询订单列表")
    @PostMapping("/listusername/{username}")
    public ServerResponseVO<UserOrderPO> listUserOrderByUsername(String username){
        return ServerResponseVO.success(userOrderPOService.listUserOrderByUsername(username));

    }

    @ApiOperation(value = "根据【用户名】查询订单列表加分页")
    @PostMapping("/listusernamepage/{username}/{current}/{size}")
    public ServerResponseVO<UserOrderPO> listUserOrderByUsernamePage(@PathVariable("username") String username,
                                                                     @PathVariable("current") int current,
                                                                     @PathVariable("size") int size) {
        return ServerResponseVO.success(userOrderPOService.listUserOrderByUsernamePage(username,current,size));

    }



    @ApiOperation(value = "根据【供应商】查询订单列表")
    @PostMapping("/listsupplier/{supplier}")
    public ServerResponseVO<UserOrderPO> listUserOrderBySupplier(String supplier){
        return ServerResponseVO.success(userOrderPOService.listUserOrderBySupplier(supplier));

    }

    @ApiOperation(value = "根据【供应商】查询订单列表加分页")
    @PostMapping("/listpagesupplier/{supplier}/{current}/{size}")
    public ServerResponseVO<UserOrderPO> listUserOrderBySuppplierPage(@PathVariable("supplier") String supplier,
                                                                     @PathVariable("current") int current,
                                                                     @PathVariable("size") int size) {
        return ServerResponseVO.success(userOrderPOService.listUserOrderBySupplierPage(supplier,current,size));

    }




}
