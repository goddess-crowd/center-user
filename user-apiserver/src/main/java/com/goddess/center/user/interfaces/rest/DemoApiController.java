package com.goddess.center.user.interfaces.rest;

import com.goddess.center.user.application.inter.DemoAppService;
import com.goddess.center.user.es.res.DemoEsResDto;
import com.goddess.center.user.infrastructure.acl.feign.UserServiceFeign;
import com.goddess.center.user.infrastructure.es.service.DemoEsService;
import com.goddess.center.user.interfaces.DemoApi;
import com.goddess.center.user.dto.req.DemoReqDto;
import com.goddess.center.user.dto.res.DemoResDto;
import com.goddess.common.web.PageResult;
import io.swagger.annotations.*;
import com.goddess.common.web.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/7 下午12:02
 * @Copyright © 女神帮
 */
@Slf4j
@Api(tags = {"示例"})
@RestController
@RequestMapping("/demo")
public class DemoApiController implements DemoApi {
    @Autowired
  private DemoAppService demoAppService;
    @Autowired
    private DemoEsService demoEsService;
    @Autowired
    private UserServiceFeign userServiceFeign;

    @Override
    @ApiOperation(value = "创建示例",tags = {"示例"}, nickname = "addDemo")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "000000:成功，否则失败")})
    @PostMapping(consumes = {"application/json"}, produces = {"application/json"})
    public ResultResponse<DemoResDto> addDemo(
            @ApiParam(value = "要保存的示例", required = true) @Valid @RequestBody DemoReqDto reqDto) {
        return ResultResponse.ok(demoAppService.save(reqDto));
    }

    @Override
    @ApiOperation(value = "删除单个或多个示例", tags = {"示例"}, nickname = "deleteDemo")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "操作是否成功,000000:成功，否则失败")})
    @DeleteMapping(value = "/{ids}", produces = {"application/json"})
    public ResultResponse<Void> deleteDemo(
            @ApiParam(value = "英文逗号隔开要删除的示例主键", required = true) @PathVariable("ids") String ids) {
        return ResultResponse.ok(demoAppService.deleteByIds(ids));
    }

    @Override
    @ApiOperation(value = "查询一个示例", tags = {"示例"}, nickname = "selectById")
    @GetMapping(value = "/{id}", produces = {"application/json"})
    public ResultResponse<DemoResDto> selectById(
            @ApiParam(value = "示例主键", required = true) @PathVariable("id") Long id) {
        return ResultResponse.ok(demoAppService.selectById(id));
    }
    @Override
    @ApiOperation(value = "分页查询示例", nickname = "getPage")
    @ApiImplicitParams({@ApiImplicitParam(name = "current", value = "当前页页数", paramType = "query", dataType = "long"),
            @ApiImplicitParam(name = "size", value = "每页条数", paramType = "query", dataType = "long"),
            @ApiImplicitParam(name = "sorter", value = "排序条件 desc-字段名或者asc-字段名", paramType = "query"),
            @ApiImplicitParam(name = "qp-localDate-eq", value = "日期", paramType = "query"),
            @ApiImplicitParam(name = "qp-localTime-eq", value = "时间", paramType = "query"),
            @ApiImplicitParam(name = "qp-localDateTime-eq", value = "日期时间", paramType = "query"),
            @ApiImplicitParam(name = "qp-retailPrice-eq", value = "零售价", paramType = "query"),
            @ApiImplicitParam(name = "qp-purchasePrice-eq", value = "进货价", paramType = "query"),
            @ApiImplicitParam(name = "qp-wholesalePrice-eq", value = "批发价", paramType = "query"),
            @ApiImplicitParam(name = "qp-createUserId-eq", value = "创建人", paramType = "query"),
            @ApiImplicitParam(name = "qp-modifyUserId-eq", value = "修改人", paramType = "query"),
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "操作是否成功,000000:成功，否则失败")})
    @GetMapping(produces = {"application/json"})
    public ResultResponse<PageResult<DemoResDto>> getPage(@ApiIgnore @RequestParam Map<String, Object> params){
        return ResultResponse.ok(demoAppService.getPage(params));
    }


  /**
   * 更新一个示例(部分更新)
   */
  @Override
  @ApiOperation(value = "更新一个示例(部分更新)", tags = {"示例"}, nickname = "updateDemoByMap")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "nodeId", value = "包含节点id", paramType = "query"),
          @ApiImplicitParam(name = "remark", value = "备注", paramType = "query")
  })
  @PatchMapping(value = "/map/{id}", produces = {"application/json"})
  @ApiResponses(value = {@ApiResponse(code = 200, message = "操作是否成功,000000:成功，否则失败")})
  public ResultResponse<DemoResDto> updateByMap(@ApiParam(value = "对象ID", required = true) @PathVariable("id") Long id,
                                                @ApiIgnore @RequestParam Map<String, Object> params){
    return ResultResponse.ok(demoAppService.updateByMap(id,params));
  }



//  @Override
//  @ApiOperation(value = "放入es一个示例", tags = {"示例"}, nickname = "initDemoToEs")
//  @PostMapping(value = "/es/{id}", produces = {"application/json"})
//  public ResultResponse<PageResult<DemoEsResDto>> initDemoToEs(
//          @ApiParam(value = "示例主键", required = true) @PathVariable("id") Long id) {
//    return ResultResponse.ok(demoEsService.initDemoToEs(id));
//  }

}
