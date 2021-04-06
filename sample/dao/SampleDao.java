package com.dalbit.sample.dao;

import com.dalbit.common.vo.ProcedureVo;
import com.dalbit.sample.vo.procedure.P_SampleListVo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SampleDao {
    //@Transactional(readOnly = true)
    List<P_SampleListVo> callList(ProcedureVo procedureVo);
}
