package com.kindergarten.basic.result;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kindergarten.teacher.entity.Teacher;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo<T> {

    private T list;

    private Long pageSize;

    private Long pageNum;

    private Long total;

    public static <T> PageInfo<List<T>> formDbPage(IPage<T> page) {
        return new PageInfo<>(page.getRecords(), page.getSize(), page.getCurrent(), page.getTotal());
    }
}
