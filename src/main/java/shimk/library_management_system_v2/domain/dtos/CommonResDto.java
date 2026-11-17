package shimk.library_management_system_v2.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResDto<T>{
    private String status;
    private String errCode;
    private String errMsg;
    private T data;

    public static<T> CommonResDto<T> data (String status ,String errCode, String errMsg){
        CommonResDto<T> commonResDto = new CommonResDto<>();
        commonResDto.setStatus(status);
        commonResDto.setErrCode(errCode);
        commonResDto.setErrMsg(errMsg);

        return commonResDto;
    }

    public static<T> CommonResDto<T> data (String status, String errCode, String errMsg, T data){
        CommonResDto<T> commonResDto = new CommonResDto<>();
        commonResDto.setStatus(status);
        commonResDto.setErrCode(errCode);
        commonResDto.setErrMsg(errMsg);
        commonResDto.setData(data);

        return commonResDto;
    }
}