package com.fcfz.telbot.common;

import com.fcfz.telbot.dto.buttomDTO;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class util {

    public static InlineKeyboardMarkup newButton(buttomDTO button1 ,buttomDTO... buttonMore){

        List<buttomDTO> buttons = new ArrayList<buttomDTO>();

        for(buttomDTO button : buttonMore){
            buttons.add(button);
        }

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();  //创建内置对象
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();   //键盘
        List<InlineKeyboardButton> rowInline = new ArrayList<>();  //按钮组

        for(buttomDTO button : buttons){
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setText(button.getText());
            inlineKeyboardButton.setCallbackData(button.getCallbackData());
            rowInline.add(inlineKeyboardButton);
            rowsInline.add(rowInline);
            markupInline.setKeyboard(rowsInline);
        }

//                内置键盘按钮
//        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();//按钮1
//        inlineKeyboardButton.setText("按钮1-更新消息···");
//        inlineKeyboardButton.setCallbackData("backData 1");
//
//        InlineKeyboardButton bt2 = new InlineKeyboardButton();//按钮
//        bt2.setText("按钮2-测试思维···");
//        bt2.setCallbackData("testData 2");
//
//        rowInline.add(inlineKeyboardButton);
//        rowInline.add(bt2);
//        rowsInline.add(rowInline);
        return markupInline;
    }
}
