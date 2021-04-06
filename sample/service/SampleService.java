package com.dalbit.sample.service;

import com.dalbit.common.code.Status;
import com.dalbit.common.vo.*;
import com.dalbit.sample.dao.SampleDao;
import com.dalbit.sample.vo.*;
import com.dalbit.sample.vo.procedure.*;
import com.dalbit.member.vo.MemberVo;
import com.dalbit.socket.service.SocketService;
import com.dalbit.socket.vo.SocketVo;
import com.dalbit.util.DalbitUtil;
import com.dalbit.util.GsonUtil;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Member;
import java.util.*;

@Slf4j
@Service
public class SampleService {
    @Autowired
    SampleDao sampleDao;
    @Autowired
    GsonUtil gsonUtil;

    /**
     * 리스트
     */
    public String callList(P_SampleListVo pSampleListVo) {
        ProcedureVo procedureVo = new ProcedureVo(pSampleListVo);
        List<P_SampleListVo> sampleListVo = sampleDao.callSampleList(procedureVo);

        String result;
        HashMap mapList = new HashMap();
        if(Integer.parseInt(procedureVo.getRet()) > -1) {
            HashMap resultMap = new Gson().fromJson(procedureVo.getExt(), HashMap.class);
            List<SampleListOutVo> outVoList = new ArrayList<>();

            if(!DalbitUtil.isEmpty(sampleListVo)){
                for (int i=0; i<sampleListVo.size(); i++){
                    outVoList.add(new SampleListOutVo(sampleListVo.get(i)));
                }
            }

            mapList.put("list", outVoList);
            mapList.put("isMailboxOn", DalbitUtil.getIntMap(resultMap, "mailboxOnOff") == 1);
            mapList.put("paging", new PagingVo(Integer.valueOf(procedureVo.getRet()), DalbitUtil.getIntMap(resultMap, "pageNo"), DalbitUtil.getIntMap(resultMap, "pageCnt")));

            result = gsonUtil.toJson(new JsonOutputVo(Status.조회_성공, mapList));
        } else if (procedureVo.getRet().equals(Status.조회_회원아님.getMessageCode())) {
            result = gsonUtil.toJson(new JsonOutputVo(Status.조회_회원아님));
        }else{
            result = gsonUtil.toJson(new JsonOutputVo(Status.조회_실패));
        }
        return result;
    }
}
