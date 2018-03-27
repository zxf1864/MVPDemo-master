package com.example.administrator.mvpdemo.ui.LayoutData;

import com.example.administrator.mvpdemo.Model.ItemAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaofeizhang on 2018/2/26.
 */

public class LayoutData {

    private static String mRectFMsg0 = "[{\"bottom\":600.0,\"left\":0.0,\"right\":900.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":0.0,\"right\":450.0,\"top\":600.0}," +
            "{\"bottom\":800.0,\"left\":450.0,\"right\":900.0,\"top\":600.0}," +
            "{\"bottom\":400.0,\"left\":900.0,\"right\":1500.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":900.0,\"right\":1500.0,\"top\":400.0}," +
            "{\"bottom\":400.0,\"left\":1500.0,\"right\":2100.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1500.0,\"right\":2100.0,\"top\":400.0}]";


    private static ItemAttribute.VideoItemType[] mItemType0 = {
                                                                    ItemAttribute.VideoItemType.BANNER,
                                                                    ItemAttribute.VideoItemType.NOTEXTBLOCK,
                                                                    ItemAttribute.VideoItemType.NOTEXTBLOCK,
                                                                    ItemAttribute.VideoItemType.TVBLOCK,
                                                                    ItemAttribute.VideoItemType.TVBLOCK,
                                                                    ItemAttribute.VideoItemType.TVBLOCK,
                                                                    ItemAttribute.VideoItemType.TVBLOCK,
                                                                };

    private static String mRectFMsg1 = "[{\"bottom\":450.0,\"left\":0.0,\"right\":700.0,\"top\":0.0}," +
            "{\"bottom\":600.0,\"left\":0.0,\"right\":375.0,\"top\":450.0}," +
            "{\"bottom\":800.0,\"left\":0.0,\"right\":375.0,\"top\":600.0}," +
            "{\"bottom\":650.0,\"left\":375.0,\"right\":700.0,\"top\":450.0}," +
            "{\"bottom\":800.0,\"left\":375.0,\"right\":700.0,\"top\":650.0}," +

            "{\"bottom\":450.0,\"left\":700.0,\"right\":1200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":700.0,\"right\":1200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":1200.0,\"right\":1700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1200.0,\"right\":1700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":1700.0,\"right\":2200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1700.0,\"right\":2200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":2200.0,\"right\":2700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2200.0,\"right\":2700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":2700.0,\"right\":3200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2700.0,\"right\":3200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":3200.0,\"right\":3700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3200.0,\"right\":3700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":3700.0,\"right\":4200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3700.0,\"right\":4200.0,\"top\":450.0}]";

    private static ItemAttribute.VideoItemType[] mItemType1 = {
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TEXTBLOCK,
            ItemAttribute.VideoItemType.ROUNDBLOCK,
            ItemAttribute.VideoItemType.ROUNDBLOCK,
            ItemAttribute.VideoItemType.ROUNDBLOCK,

            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK

    };



    private static String mRectFMsg2 = "[{\"bottom\":450.0,\"left\":0.0,\"right\":700.0,\"top\":0.0}," +
            "{\"bottom\":650.0,\"left\":0.0,\"right\":375.0,\"top\":450.0}," +
            "{\"bottom\":800.0,\"left\":0.0,\"right\":375.0,\"top\":650.0}," +
            "{\"bottom\":650.0,\"left\":375.0,\"right\":700.0,\"top\":450.0}," +
            "{\"bottom\":800.0,\"left\":375.0,\"right\":700.0,\"top\":650.0}," +

            "{\"bottom\":450.0,\"left\":700.0,\"right\":1200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":700.0,\"right\":1200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":1200.0,\"right\":1700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1200.0,\"right\":1700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":1700.0,\"right\":2200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1700.0,\"right\":2200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":2200.0,\"right\":2700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2200.0,\"right\":2700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":2700.0,\"right\":3200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2700.0,\"right\":3200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":3200.0,\"right\":3700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3200.0,\"right\":3700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":3700.0,\"right\":4200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3700.0,\"right\":4200.0,\"top\":450.0}]";

    private static ItemAttribute.VideoItemType[] mItemType2 = {
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,

            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK

    };


    private static String mRectFMsg3 = "[{\"bottom\":450.0,\"left\":0.0,\"right\":700.0,\"top\":0.0}," +
            "{\"bottom\":650.0,\"left\":0.0,\"right\":375.0,\"top\":450.0}," +
            "{\"bottom\":800.0,\"left\":0.0,\"right\":375.0,\"top\":650.0}," +
            "{\"bottom\":650.0,\"left\":375.0,\"right\":700.0,\"top\":450.0}," +
            "{\"bottom\":800.0,\"left\":375.0,\"right\":700.0,\"top\":650.0}," +

            "{\"bottom\":450.0,\"left\":700.0,\"right\":1200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":700.0,\"right\":1200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":1200.0,\"right\":1700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1200.0,\"right\":1700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":1700.0,\"right\":2200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1700.0,\"right\":2200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":2200.0,\"right\":2700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2200.0,\"right\":2700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":2700.0,\"right\":3200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2700.0,\"right\":3200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":3200.0,\"right\":3700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3200.0,\"right\":3700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":3700.0,\"right\":4200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3700.0,\"right\":4200.0,\"top\":450.0}]";

    private static ItemAttribute.VideoItemType[] mItemType3 = {
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TEXTBLOCK,
            ItemAttribute.VideoItemType.TEXTBLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,

            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK

    };


    private static String mRectFMsg4 = "[{\"bottom\":200.0,\"left\":0.0,\"right\":400.0,\"top\":0.0}," +
            "{\"bottom\":400.0,\"left\":0.0,\"right\":400.0,\"top\":200.0}," +
            "{\"bottom\":600.0,\"left\":0.0,\"right\":400.0,\"top\":400.0}," +
            "{\"bottom\":800.0,\"left\":0.0,\"right\":400.0,\"top\":600.0}," +


            "{\"bottom\":400.0,\"left\":400.0,\"right\":800.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":400.0,\"right\":800.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":800.0,\"right\":1200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":800.0,\"right\":1200.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":1200.0,\"right\":1600.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1200.0,\"right\":1600.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":1600.0,\"right\":2000.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1600.0,\"right\":2000.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2000.0,\"right\":2400.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2000.0,\"right\":2400.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2400.0,\"right\":2800.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2400.0,\"right\":2800.0,\"top\":400.0}]";


    private static ItemAttribute.VideoItemType[] mItemType4 = {
            ItemAttribute.VideoItemType.FIRSTBLOCK,
            ItemAttribute.VideoItemType.TEXTBLOCK,
            ItemAttribute.VideoItemType.TEXTBLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,

            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,


    };


    private static String mRectFMsg5 = "[{\"bottom\":200.0,\"left\":0.0,\"right\":400.0,\"top\":0.0}," +
            "{\"bottom\":400.0,\"left\":0.0,\"right\":400.0,\"top\":200.0}," +
            "{\"bottom\":600.0,\"left\":0.0,\"right\":400.0,\"top\":400.0}," +
            "{\"bottom\":800.0,\"left\":0.0,\"right\":400.0,\"top\":600.0}," +


            "{\"bottom\":400.0,\"left\":400.0,\"right\":1200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":400.0,\"right\":1200.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":1200.0,\"right\":2000.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1200.0,\"right\":2000.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2000.0,\"right\":2400.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2000.0,\"right\":2400.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2400.0,\"right\":3200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2400.0,\"right\":3200.0,\"top\":400.0}," +


            "{\"bottom\":400.0,\"left\":3200.0,\"right\":4000.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3200.0,\"right\":4000.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":4000.0,\"right\":4400.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":4000.0,\"right\":4400.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":4400.0,\"right\":5200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":4400.0,\"right\":5200.0,\"top\":400.0}]";

    private static ItemAttribute.VideoItemType[] mItemType5 = {
            ItemAttribute.VideoItemType.TEXTBLOCK,
            ItemAttribute.VideoItemType.TEXTBLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,

            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,

    };



    private static String mRectFMsg6 = "[{\"bottom\":200.0,\"left\":0.0,\"right\":400.0,\"top\":0.0}," +
            "{\"bottom\":400.0,\"left\":0.0,\"right\":400.0,\"top\":200.0}," +
            "{\"bottom\":600.0,\"left\":0.0,\"right\":400.0,\"top\":400.0}," +
            "{\"bottom\":800.0,\"left\":0.0,\"right\":400.0,\"top\":600.0}," +


            "{\"bottom\":400.0,\"left\":400.0,\"right\":1200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":400.0,\"right\":1200.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":1200.0,\"right\":2000.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1200.0,\"right\":2000.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2000.0,\"right\":2400.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2000.0,\"right\":2400.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2400.0,\"right\":3200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2400.0,\"right\":3200.0,\"top\":400.0}," +


            "{\"bottom\":400.0,\"left\":3200.0,\"right\":4000.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3200.0,\"right\":4000.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":4000.0,\"right\":4400.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":4000.0,\"right\":4400.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":4400.0,\"right\":5200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":4400.0,\"right\":5200.0,\"top\":400.0}]";

    private static ItemAttribute.VideoItemType[] mItemType6 = {
            ItemAttribute.VideoItemType.TEXTBLOCK,
            ItemAttribute.VideoItemType.TEXTBLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,

            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,

    };




    private static String mRectFMsg7 ="[{\"bottom\":200.0,\"left\":0.0,\"right\":400.0,\"top\":0.0}," +
            "{\"bottom\":400.0,\"left\":0.0,\"right\":400.0,\"top\":200.0}," +
            "{\"bottom\":600.0,\"left\":0.0,\"right\":400.0,\"top\":400.0}," +
            "{\"bottom\":800.0,\"left\":0.0,\"right\":400.0,\"top\":600.0}," +


            "{\"bottom\":400.0,\"left\":400.0,\"right\":1400.0,\"top\":0.0}," +
            "{\"bottom\":600.0,\"left\":400.0,\"right\":900.0,\"top\":400.0}," +
            "{\"bottom\":800.0,\"left\":400.0,\"right\":900.0,\"top\":600.0}," +
            "{\"bottom\":600.0,\"left\":900.0,\"right\":1400.0,\"top\":400.0}," +
            "{\"bottom\":800.0,\"left\":900.0,\"right\":1400.0,\"top\":600.0}," +


            "{\"bottom\":400.0,\"left\":1400.0,\"right\":2000.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1400.0,\"right\":2000.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2000.0,\"right\":2400.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2000.0,\"right\":2400.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2400.0,\"right\":3200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2400.0,\"right\":3200.0,\"top\":400.0}," +


            "{\"bottom\":400.0,\"left\":3200.0,\"right\":4000.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3200.0,\"right\":4000.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":4000.0,\"right\":4400.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":4000.0,\"right\":4400.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":4400.0,\"right\":5200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":4400.0,\"right\":5200.0,\"top\":400.0}]";


    private static ItemAttribute.VideoItemType[] mItemType7 = {
            ItemAttribute.VideoItemType.TEXTBLOCK,
            ItemAttribute.VideoItemType.TEXTBLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,

            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,

    };



    private static String mRectFMsg8 = "[{\"bottom\":800.0,\"left\":0.0,\"right\":300.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":300.0,\"right\":500.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":500.0,\"right\":700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":700.0,\"right\":900.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":900.0,\"right\":1100.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1100.0,\"right\":1300.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1300.0,\"right\":1500.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1500.0,\"right\":1700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1700.0,\"right\":1900.0,\"top\":0.0}," +

            "{\"bottom\":800.0,\"left\":1900.0,\"right\":2100.0,\"top\":0.0}]";


    private static ItemAttribute.VideoItemType[] mItemType8 = {
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,

            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
    };

    private static String mRectFMsg9 = "[{\"bottom\":200.0,\"left\":0.0,\"right\":400.0,\"top\":0.0}," +
            "{\"bottom\":400.0,\"left\":0.0,\"right\":400.0,\"top\":200.0}," +
            "{\"bottom\":600.0,\"left\":0.0,\"right\":400.0,\"top\":400.0}," +
            "{\"bottom\":800.0,\"left\":0.0,\"right\":400.0,\"top\":600.0}," +


            "{\"bottom\":400.0,\"left\":400.0,\"right\":1000.0,\"top\":0.0}," +
            "{\"bottom\":600.0,\"left\":400.0,\"right\":700.0,\"top\":400.0}," +
            "{\"bottom\":800.0,\"left\":400.0,\"right\":700.0,\"top\":600.0}," +
            "{\"bottom\":600.0,\"left\":700.0,\"right\":1000.0,\"top\":400.0}," +
            "{\"bottom\":800.0,\"left\":700.0,\"right\":1000.0,\"top\":600.0}," +

            "{\"bottom\":400.0,\"left\":2000.0,\"right\":2400.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2000.0,\"right\":2400.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2400.0,\"right\":3200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2400.0,\"right\":3200.0,\"top\":400.0}," +


            "{\"bottom\":400.0,\"left\":3200.0,\"right\":4000.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3200.0,\"right\":4000.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":4000.0,\"right\":4400.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":4000.0,\"right\":4400.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":4400.0,\"right\":5200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":4400.0,\"right\":5200.0,\"top\":400.0}]";

    private static ItemAttribute.VideoItemType[] mItemType9 = {
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,
            ItemAttribute.VideoItemType.BLOCK,

            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.ROUNDBLOCK,
            ItemAttribute.VideoItemType.ROUNDBLOCK,
            ItemAttribute.VideoItemType.ROUNDBLOCK,
            ItemAttribute.VideoItemType.ROUNDBLOCK,

            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK,
            ItemAttribute.VideoItemType.TVBLOCK
    };



    private static String[] inputStrs = {mRectFMsg0,mRectFMsg1,mRectFMsg2,mRectFMsg3,mRectFMsg4,mRectFMsg5,mRectFMsg6,mRectFMsg7,mRectFMsg8,mRectFMsg9};

    private static  ItemAttribute.VideoItemType[][] inputTypes = {mItemType0,mItemType1,mItemType2,mItemType3,mItemType4,mItemType5,mItemType6,mItemType7,mItemType8,mItemType9};


    public static String[] GetLayoutData()
    {
        return inputStrs;
    }

    public static ItemAttribute.VideoItemType[][] GetLayoutType()
    {
        return inputTypes;
    }



    private static LayoutData mLayoutData;  //静态变量

    public Map<String, String> getinputMap() {
        return inputMap;
    }

    private Map<String,String> inputMap;

    private LayoutData (){
        inputMap = new HashMap<String,String>();//使用HashMap作为缓存容器
        inputMap.put("28",mRectFMsg0);
        inputMap.put("29",mRectFMsg1);
        inputMap.put("30",mRectFMsg2);
        inputMap.put("31",mRectFMsg3);
        inputMap.put("32",mRectFMsg4);
        inputMap.put("34",mRectFMsg5);

    }  //私有构造函数

    public static LayoutData getInstance() {
        if (mLayoutData == null) {  //第一层校验
            synchronized (LayoutData.class) {
                if (mLayoutData == null) {  //第二层校验
                    mLayoutData = new LayoutData();
                }
            }
        }
        return mLayoutData;
    }


}
