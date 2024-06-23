package com.fcfz.telbot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class buttomDTO {
    private String text;  // 按鈕文字
    private String callbackData;  // 按鈕回傳資料
}
