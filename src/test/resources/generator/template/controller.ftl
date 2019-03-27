package ${basePackage}.web.controller;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.service.${modelNameUpperCamel}Service;
import ${basePackage}.enums.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by ${author} on ${date}.
 */
@RestController
@RequestMapping("/${baseRequestMapping}/")
public class ${modelNameUpperCamel}Controller {

    @Autowired
    ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @RequestMapping("add")
    public Map<String,Object> add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return Result.retrunSucess();
    }

    @RequestMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    ${modelNameLowerCamel}Service.deleteById(id);
	    return Result.retrunSucess();
    }

    @RequestMapping("update")
    public Map<String,Object> update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
	    ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
	    return Result.retrunSucess();
    }

    @RequestMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return Result.retrunSucessMsgData(${modelNameLowerCamel});
    }

    @RequestMapping("list")
    public Map<String,Object> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit) {
        PageHelper.startPage(page, limit);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> map=Result.retrunSucessMsgData(pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        return map;
    }
}
