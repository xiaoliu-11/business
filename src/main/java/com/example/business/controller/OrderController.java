package com.example.business.controller;


import com.example.business.annotation.LogAnnotation;
import com.example.business.entity.UserOrderPO;
import com.example.business.service.UserOrderPOService;
import com.example.business.vo.order.UserOrderVO;
import com.example.business.vo.res.OrderPageResVO;
import com.example.business.vo.res.OrderPageSupplierResVO;
import com.example.business.vo.res.OrderPageUsernameResVO;
import com.example.business.vo.response.ServerResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api("订单接口模块")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserOrderPOService userOrderPOService;


    @RequiresRoles("admin")
    @ApiOperation(value = "根据id查询用户订单")
    @PostMapping("/{id}")
    public ServerResponseVO<UserOrderPO> getUserOrderById(@PathVariable("id") int id) {
        return ServerResponseVO.success(userOrderPOService.getById(id));
    }


    @RequiresRoles("admin")
    @ApiOperation(value = "查询所有订单")
    @PostMapping("/orderall")
    public ServerResponseVO<List<UserOrderPO>> listOrder() {
        return ServerResponseVO.success(userOrderPOService.list());
    }

    @RequiresRoles("admin")
    @ApiOperation(value = "分页查询订单")
    @PostMapping("/orderpage/{current}/{size}")
    public ServerResponseVO<UserOrderPO> getUserOrderPage(@Valid @RequestBody OrderPageResVO orderPageResVO) {
        return ServerResponseVO.success(userOrderPOService.getUserOrderPage(orderPageResVO.getCurrent(), orderPageResVO.getSize()));
    }

    @RequiresRoles("admin")
    @ApiOperation(value = "添加或者修改订单")
    @PostMapping("/save")
    public ServerResponseVO<?> saveOrder(@RequestBody UserOrderVO userOrderVO) {
        return ServerResponseVO.success(userOrderPOService.saveOrUpdateOrder(userOrderVO));
    }

    @RequiresRoles("admin")
    @LogAnnotation(value = "通过统一返回的接口查询所有订单")
    @ApiOperation(value = "通过统一返回的接口查询所有订单")
    @PostMapping("/orderalltwo")
    public ServerResponseVO<UserOrderPO> listUserOrder() {
        return ServerResponseVO.success(userOrderPOService.list());

    }


    @RequiresRoles("admin")
    @ApiOperation(value = "根据id删除订单")
    @PostMapping("/deleteOrder/{id}")
    public ServerResponseVO<?> deleteOrderById(@PathVariable("id") int id) {
        return ServerResponseVO.success(userOrderPOService.removeById(id));

    }


    @RequiresRoles(value = {"owner","admin"},logical= Logical.OR)
    @ApiOperation(value = "根据【用户名】查询订单列表")
    @PostMapping("/listusername/{username}")
    public ServerResponseVO<UserOrderPO> listUserOrderByUsername(@PathVariable("username") String username) {
        return ServerResponseVO.success(userOrderPOService.listUserOrderByUsername(username));

    }


    @RequiresRoles(value = {"owner","admin"},logical= Logical.OR)
    @ApiOperation(value = "根据【用户名】查询订单列表加分页")
    @PostMapping("/listusernamepage/{username}/{current}/{size}")
    public ServerResponseVO<UserOrderPO> listUserOrderByUsernamePage(@Valid @RequestBody OrderPageUsernameResVO orderPageUsernameResVO) {
        return ServerResponseVO.success(userOrderPOService.listUserOrderByUsernamePage(orderPageUsernameResVO.getUsername(), orderPageUsernameResVO.getCurrent(), orderPageUsernameResVO.getSize()));

    }


    //属于user或者admin之一;修改logical为OR 即可
    // @RequiresRoles(value={"carrier","admin"},logical= Logical.OR)

    @RequiresRoles(value = {"carrier","admin"},logical= Logical.OR)
    @ApiOperation(value = "根据【供应商】查询订单列表")
    @PostMapping("/listsupplier/{supplier}")
    public ServerResponseVO<UserOrderPO> listUserOrderBySupplier(@PathVariable("supplier") String supplier) {
        return ServerResponseVO.success(userOrderPOService.listUserOrderBySupplier(supplier));

    }



    @RequiresRoles(value = {"carrier","admin"},logical= Logical.OR)
    @ApiOperation(value = "根据【供应商】查询订单列表加分页")
    @PostMapping("/listpagesupplier/{supplier}/{current}/{size}")
    public ServerResponseVO<UserOrderPO> listUserOrderBySuppplierPage(@Valid @RequestBody OrderPageSupplierResVO orderPageSupplierResVO) {
        return ServerResponseVO.success(userOrderPOService.listUserOrderBySupplierPage(orderPageSupplierResVO.getSupplier(), orderPageSupplierResVO.getCurrent(), orderPageSupplierResVO.getSize()));

    }


}
