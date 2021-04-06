package com.dalbit.sample.vo.procedure;

import com.dalbit.common.vo.P_ApiVo;
import com.dalbit.sample.vo.request.P_SampleListVo;
import com.dalbit.member.vo.MemberVo;
import com.dalbit.util.DalbitUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Getter @Setter @ToString
public class P_SampleListVo extends P_ApiVo {

    public P_SampleListVo(){}
    public P_SampleListVo(SampleListVo sampleListVo, HttpServletRequest request){
        int pageNo = DalbitUtil.isEmpty(sampleListVo.getPage()) ? 1 : sampleListVo.getPage();
        int pageCnt = DalbitUtil.isEmpty(sampleListVo.getRecords()) ? 10 : sampleListVo.getRecords();

        setMem_no(MemberVo.getMyMemNo(request));
        setPageNo(pageNo);
        setPageCnt(pageCnt);
    }

    /* Input */
    private String mem_no;
    private int pageNo;         //현재 페이지 번호
    private int pageCnt;        //페이지당 리스트 개수

    /* Output */
    private String target_mem_no;
    private String chat_no;
    private String title;
    private String memSex;
    private String profileImage;
    private int unreadCnt;
    private int msgType;
    private String lastMsg;
    private String addData1;
    private String addData2;
    private String addData3;
    private String addData4;
    private String addData5;
    private String addData6;
    private String addData7;
    private String addData8;
    private String addData9;
    private Date lastMsgDate;
}
