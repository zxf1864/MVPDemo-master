package com.example.administrator.mvpdemo.service.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xiaofeizhang on 2018/2/26.
 */

public class PgcInfo {

    /**
     * status : 200
     * statusText : OK
     * data : {"count":13346,"videos":[{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M04/D0/34/MTAuMTAuODguODI=/6_162bb6dc603g102SysCutcloud_98400134_7_0b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M04/D0/34/MTAuMTAuODguODI=/6_162bb6dc603g102SysCutcloud_98400134_7_0b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M04/D0/34/MTAuMTAuODguODI=/6_162bb6dc603g102SysCutcloud_98400134_7_0b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M04/D0/34/MTAuMTAuODguODI=/6_162bb6dc603g102SysCutcloud_98400134_7_0b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 15:18:02","score":0,"play_count":0,"time_length":58,"vid":98400134,"video_name":"\u201c中原飓风\u201d闫西波TKO曾我英将，赛后姿势亮了连裁判都目瞪口呆","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M04/D0/34/MTAuMTAuODguODI=/6_162bb6dc603g102SysCutcloud_98400134_7_0b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/32/MTAuMTAuODguODI=/6_162bb69625cg102SysCutcloud_98399805_7_1b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/32/MTAuMTAuODguODI=/6_162bb69625cg102SysCutcloud_98399805_7_1b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/32/MTAuMTAuODguODI=/6_162bb69625cg102SysCutcloud_98399805_7_1b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/32/MTAuMTAuODguODI=/6_162bb69625cg102SysCutcloud_98399805_7_1b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 15:12:03","score":0,"play_count":0,"time_length":253,"vid":98399805,"video_name":"摔角盘点TOP 历史七次斯蒂芬妮最为受辱时刻","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/32/MTAuMTAuODguODI=/6_162bb69625cg102SysCutcloud_98399805_7_1b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group3/M04/CF/F1/MTAuMTAuODguODQ=/6_162bb66c0dfg102SysCutcloud_98399597_7_1b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group3/M04/CF/F1/MTAuMTAuODguODQ=/6_162bb66c0dfg102SysCutcloud_98399597_7_1b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group3/M04/CF/F1/MTAuMTAuODguODQ=/6_162bb66c0dfg102SysCutcloud_98399597_7_1b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group3/M04/CF/F1/MTAuMTAuODguODQ=/6_162bb66c0dfg102SysCutcloud_98399597_7_1b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 15:09:52","score":0,"play_count":0,"time_length":178,"vid":98399597,"video_name":"巨石强森送葬者凯恩轮流暴虐小麦 哈哈哈求小麦的心理阴影面积","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M04/CF/F1/MTAuMTAuODguODQ=/6_162bb66c0dfg102SysCutcloud_98399597_7_1b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9437928,"album_name":"海外健身","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M07/D0/31/MTAuMTAuODguODE=/6_162bb6175bdg104SysCutcloudSrcimag_98399173_7_3b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M07/D0/31/MTAuMTAuODguODE=/6_162bb6175bdg104SysCutcloudSrcimag_98399173_7_3b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M07/D0/31/MTAuMTAuODguODE=/6_162bb6175bdg104SysCutcloudSrcimag_98399173_7_3b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M07/D0/31/MTAuMTAuODguODE=/6_162bb6175bdg104SysCutcloudSrcimag_98399173_7_3b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 15:00:34","score":0,"play_count":0,"time_length":281,"vid":98399173,"video_name":"国外各种极限运动失误, 简直不敢直视","video_desc":"国外各种极限运动失误,简直不敢直视","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M07/D0/31/MTAuMTAuODguODE=/6_162bb6175bdg104SysCutcloudSrcimag_98399173_7_3b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9437928,"album_name":"海外健身","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M02/D0/33/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MjkyNDUwODQ=/cut@m=force,w=240,h=330.png","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M02/D0/33/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MjkyNDUwODQ=/cut@m=force,w=240,h=180.png","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M02/D0/33/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MjkyNDUwODQ=/cut@m=force,w=160,h=90.png","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M02/D0/33/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MjkyNDUwODQ=/cut@m=force,w=160,h=90.png","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 15:00:34","score":0,"play_count":0,"time_length":189,"vid":98399226,"video_name":"国外街头健身没人关注, 在国内小迷妹都疯了吧","video_desc":"国外街头健身没人关注,在国内小迷妹都疯了吧","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M02/D0/33/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MjkyNDUwODQ=/cut@m=force,w=320,h=180.png"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/2B/MTAuMTAuODguODI=/6_162bb533a9fg104SysCutcloud_98398493_7_1b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/2B/MTAuMTAuODguODI=/6_162bb533a9fg104SysCutcloud_98398493_7_1b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/2B/MTAuMTAuODguODI=/6_162bb533a9fg104SysCutcloud_98398493_7_1b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/2B/MTAuMTAuODguODI=/6_162bb533a9fg104SysCutcloud_98398493_7_1b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 14:46:55","score":0,"play_count":0,"time_length":384,"vid":98398493,"video_name":"昨晚，韩国选手被差点绞晕，竟用出这招！直接被判犯规告负！","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/2B/MTAuMTAuODguODI=/6_162bb533a9fg104SysCutcloud_98398493_7_1b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M03/D0/29/MTAuMTAuODguODI=/6_162bb4adb37g102SysCutcloud_98397971_7_0b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M03/D0/29/MTAuMTAuODguODI=/6_162bb4adb37g102SysCutcloud_98397971_7_0b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M03/D0/29/MTAuMTAuODguODI=/6_162bb4adb37g102SysCutcloud_98397971_7_0b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M03/D0/29/MTAuMTAuODguODI=/6_162bb4adb37g102SysCutcloud_98397971_7_0b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 14:39:16","score":0,"play_count":0,"time_length":81,"vid":98397971,"video_name":"重温经典之2014年索契冬奥会 短道速滑 女子500米 冠军李坚柔","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M03/D0/29/MTAuMTAuODguODI=/6_162bb4adb37g102SysCutcloud_98397971_7_0b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9437928,"album_name":"海外健身","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group3/M05/CF/B8/MTAuMTAuODguODM=/6_162baa483b5g102SysCutcloudSrcimag_98389933_7_0b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group3/M05/CF/B8/MTAuMTAuODguODM=/6_162baa483b5g102SysCutcloudSrcimag_98389933_7_0b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group3/M05/CF/B8/MTAuMTAuODguODM=/6_162baa483b5g102SysCutcloudSrcimag_98389933_7_0b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group3/M05/CF/B8/MTAuMTAuODguODM=/6_162baa483b5g102SysCutcloudSrcimag_98389933_7_0b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 11:35:17","score":0,"play_count":313,"time_length":169,"vid":98389933,"video_name":"国外人已经把水上极限运动玩出了新花样","video_desc":"国外人已经把水上极限运动玩出了新花样","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M05/CF/B8/MTAuMTAuODguODM=/6_162baa483b5g102SysCutcloudSrcimag_98389933_7_0b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9437928,"album_name":"海外健身","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/B8/MTAuMTAuODguODM=/6_162baa5033cg102SysCutcloudSrcimag_98389844_7_4b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/B8/MTAuMTAuODguODM=/6_162baa5033cg102SysCutcloudSrcimag_98389844_7_4b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/B8/MTAuMTAuODguODM=/6_162baa5033cg102SysCutcloudSrcimag_98389844_7_4b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/B8/MTAuMTAuODguODM=/6_162baa5033cg102SysCutcloudSrcimag_98389844_7_4b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 11:35:17","score":0,"play_count":640,"time_length":164,"vid":98389844,"video_name":"国外极限高空跳伞自由落体运动有趣精彩瞬间","video_desc":"国外极限高空跳伞自由落体运动有趣精彩瞬间","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/B8/MTAuMTAuODguODM=/6_162baa5033cg102SysCutcloudSrcimag_98389844_7_4b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M05/CF/F5/MTAuMTAuODguODI=/6_162ba9875f7g104SysCutcloud_98389413_7_0b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M05/CF/F5/MTAuMTAuODguODI=/6_162ba9875f7g104SysCutcloud_98389413_7_0b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M05/CF/F5/MTAuMTAuODguODI=/6_162ba9875f7g104SysCutcloud_98389413_7_0b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M05/CF/F5/MTAuMTAuODguODI=/6_162ba9875f7g104SysCutcloud_98389413_7_0b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 11:23:39","score":0,"play_count":17,"time_length":208,"vid":98389413,"video_name":"中国勇士金鹰的复仇之战，一拳正中对手面门","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M05/CF/F5/MTAuMTAuODguODI=/6_162ba9875f7g104SysCutcloud_98389413_7_0b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F5/MTAuMTAuODguODE=/6_162ba9733e5g104SysCutcloud_98389187_7_0b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F5/MTAuMTAuODguODE=/6_162ba9733e5g104SysCutcloud_98389187_7_0b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F5/MTAuMTAuODguODE=/6_162ba9733e5g104SysCutcloud_98389187_7_0b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F5/MTAuMTAuODguODE=/6_162ba9733e5g104SysCutcloud_98389187_7_0b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 11:21:56","score":0,"play_count":7,"time_length":243,"vid":98389187,"video_name":"刚刚，马拉特29秒KO播求大弟子苏波邦，强势登顶诸神总冠军！","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F5/MTAuMTAuODguODE=/6_162ba9733e5g104SysCutcloud_98389187_7_0b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9437928,"album_name":"海外健身","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/B2/MTAuMTAuODguODM=/6_162ba8ef85dg102SysCutcloud_98388751_7_7b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/B2/MTAuMTAuODguODM=/6_162ba8ef85dg102SysCutcloud_98388751_7_7b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/B2/MTAuMTAuODguODM=/6_162ba8ef85dg102SysCutcloud_98388751_7_7b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/B2/MTAuMTAuODguODM=/6_162ba8ef85dg102SysCutcloud_98388751_7_7b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 11:11:24","score":0,"play_count":5,"time_length":67,"vid":98388751,"video_name":"国外的体操比赛, 场面也不小","video_desc":"国外的体操比赛,场面也不小","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/B2/MTAuMTAuODguODM=/6_162ba8ef85dg102SysCutcloud_98388751_7_7b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9437928,"album_name":"海外健身","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F3/MTAuMTAuODguODE=/6_162ba8ddb43g102SysCutcloudSrcimag_98388747_7_1b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F3/MTAuMTAuODguODE=/6_162ba8ddb43g102SysCutcloudSrcimag_98388747_7_1b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F3/MTAuMTAuODguODE=/6_162ba8ddb43g102SysCutcloudSrcimag_98388747_7_1b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F3/MTAuMTAuODguODE=/6_162ba8ddb43g102SysCutcloudSrcimag_98388747_7_1b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 11:11:24","score":0,"play_count":7,"time_length":96,"vid":98388747,"video_name":"国外健身牛人单手引体向上, 小伙子你这是百年不遇的麒麟臂啊","video_desc":"国外健身牛人单手引体向上,小伙子你这是百年不遇的麒麟臂啊","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F3/MTAuMTAuODguODE=/6_162ba8ddb43g102SysCutcloudSrcimag_98388747_7_1b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M08/CF/EC/MTAuMTAuODguODE=/6_162ba7c7948g102SysCutcloud_98387975_7_1b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M08/CF/EC/MTAuMTAuODguODE=/6_162ba7c7948g102SysCutcloud_98387975_7_1b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M08/CF/EC/MTAuMTAuODguODE=/6_162ba7c7948g102SysCutcloud_98387975_7_1b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M08/CF/EC/MTAuMTAuODguODE=/6_162ba7c7948g102SysCutcloud_98387975_7_1b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 10:52:51","score":0,"play_count":6,"time_length":219,"vid":98387975,"video_name":"世界王者布洛克-莱斯纳尔被KO，宣布新的格斗时代到来了！","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M08/CF/EC/MTAuMTAuODguODE=/6_162ba7c7948g102SysCutcloud_98387975_7_1b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9437928,"album_name":"海外健身","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group3/M07/CF/A9/MTAuMTAuODguODM=/6_162ba78e4c8g104SysCutcloudSrcimag_98387560_7_2b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group3/M07/CF/A9/MTAuMTAuODguODM=/6_162ba78e4c8g104SysCutcloudSrcimag_98387560_7_2b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group3/M07/CF/A9/MTAuMTAuODguODM=/6_162ba78e4c8g104SysCutcloudSrcimag_98387560_7_2b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group3/M07/CF/A9/MTAuMTAuODguODM=/6_162ba78e4c8g104SysCutcloudSrcimag_98387560_7_2b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 10:46:09","score":0,"play_count":8,"time_length":159,"vid":98387560,"video_name":"国外健身教练的变态训练 全身运动","video_desc":"国外健身教练的变态训练全身运动","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M07/CF/A9/MTAuMTAuODguODM=/6_162ba78e4c8g104SysCutcloudSrcimag_98387560_7_2b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/9C/MTAuMTAuODguODM=/6_162ba48bd1cg104SysCutcloud_98385110_7_2b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/9C/MTAuMTAuODguODM=/6_162ba48bd1cg104SysCutcloud_98385110_7_2b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/9C/MTAuMTAuODguODM=/6_162ba48bd1cg104SysCutcloud_98385110_7_2b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/9C/MTAuMTAuODguODM=/6_162ba48bd1cg104SysCutcloud_98385110_7_2b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 09:56:02","score":0,"play_count":6,"time_length":266,"vid":98385110,"video_name":"压哨KO最后一秒放出大招回旋踢 造成对手10000点伤害秒杀","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/9C/MTAuMTAuODguODM=/6_162ba48bd1cg104SysCutcloud_98385110_7_2b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/94/MTAuMTAuODguODM=/6_162ba2beabfg102SysCutcloud_98383515_7_3b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/94/MTAuMTAuODguODM=/6_162ba2beabfg102SysCutcloud_98383515_7_3b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/94/MTAuMTAuODguODM=/6_162ba2beabfg102SysCutcloud_98383515_7_3b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/94/MTAuMTAuODguODM=/6_162ba2beabfg102SysCutcloud_98383515_7_3b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 09:25:02","score":0,"play_count":24,"time_length":248,"vid":98383515,"video_name":"中国勇士历经40小时飞行远征巴西KO巴西名将 一拳让对手站着睡着","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/94/MTAuMTAuODguODM=/6_162ba2beabfg102SysCutcloud_98383515_7_3b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group3/M09/CF/93/MTAuMTAuODguODQ=/6_162ba2799d4g102SysCutcloud_98383427_7_0b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group3/M09/CF/93/MTAuMTAuODguODQ=/6_162ba2799d4g102SysCutcloud_98383427_7_0b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group3/M09/CF/93/MTAuMTAuODguODQ=/6_162ba2799d4g102SysCutcloud_98383427_7_0b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group3/M09/CF/93/MTAuMTAuODguODQ=/6_162ba2799d4g102SysCutcloud_98383427_7_0b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 09:19:44","score":0,"play_count":32,"time_length":261,"vid":98383427,"video_name":"HHH霸气回归 复仇奥斯丁 恶劣态度时期下手有多狠？","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M09/CF/93/MTAuMTAuODguODQ=/6_162ba2799d4g102SysCutcloud_98383427_7_0b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/D3/MTAuMTAuODguODI=/6_162ba242428g104SysCutcloud_98383299_7_4b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/D3/MTAuMTAuODguODI=/6_162ba242428g104SysCutcloud_98383299_7_4b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/D3/MTAuMTAuODguODI=/6_162ba242428g104SysCutcloud_98383299_7_4b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/D3/MTAuMTAuODguODI=/6_162ba242428g104SysCutcloud_98383299_7_4b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 09:17:35","score":0,"play_count":6,"time_length":80,"vid":98383299,"video_name":"被奥运会耽误的段子手，王濛吐槽起韩国队一点都不含糊","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/D3/MTAuMTAuODguODI=/6_162ba242428g104SysCutcloud_98383299_7_4b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9437928,"album_name":"海外健身","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/DB/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MDk4MzM0MTU=/cut@m=force,w=240,h=330.png","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/DB/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MDk4MzM0MTU=/cut@m=force,w=240,h=180.png","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/DB/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MDk4MzM0MTU=/cut@m=force,w=160,h=90.png","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/DB/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MDk4MzM0MTU=/cut@m=force,w=160,h=90.png","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 08:28:55","score":0,"play_count":2,"time_length":302,"vid":98381579,"video_name":"国外90后牛人攀爬上海中心大厦650米高空最高点 挑战极限","video_desc":"国外90后牛人攀爬上海中心大厦650米高空最高点挑战极限","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/DB/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MDk4MzM0MTU=/cut@m=force,w=320,h=180.png"}]}
     */

    private int status;
    private String statusText;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * count : 13346
         * videos : [{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M04/D0/34/MTAuMTAuODguODI=/6_162bb6dc603g102SysCutcloud_98400134_7_0b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M04/D0/34/MTAuMTAuODguODI=/6_162bb6dc603g102SysCutcloud_98400134_7_0b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M04/D0/34/MTAuMTAuODguODI=/6_162bb6dc603g102SysCutcloud_98400134_7_0b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M04/D0/34/MTAuMTAuODguODI=/6_162bb6dc603g102SysCutcloud_98400134_7_0b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 15:18:02","score":0,"play_count":0,"time_length":58,"vid":98400134,"video_name":"\u201c中原飓风\u201d闫西波TKO曾我英将，赛后姿势亮了连裁判都目瞪口呆","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M04/D0/34/MTAuMTAuODguODI=/6_162bb6dc603g102SysCutcloud_98400134_7_0b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/32/MTAuMTAuODguODI=/6_162bb69625cg102SysCutcloud_98399805_7_1b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/32/MTAuMTAuODguODI=/6_162bb69625cg102SysCutcloud_98399805_7_1b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/32/MTAuMTAuODguODI=/6_162bb69625cg102SysCutcloud_98399805_7_1b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/32/MTAuMTAuODguODI=/6_162bb69625cg102SysCutcloud_98399805_7_1b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 15:12:03","score":0,"play_count":0,"time_length":253,"vid":98399805,"video_name":"摔角盘点TOP 历史七次斯蒂芬妮最为受辱时刻","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/32/MTAuMTAuODguODI=/6_162bb69625cg102SysCutcloud_98399805_7_1b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group3/M04/CF/F1/MTAuMTAuODguODQ=/6_162bb66c0dfg102SysCutcloud_98399597_7_1b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group3/M04/CF/F1/MTAuMTAuODguODQ=/6_162bb66c0dfg102SysCutcloud_98399597_7_1b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group3/M04/CF/F1/MTAuMTAuODguODQ=/6_162bb66c0dfg102SysCutcloud_98399597_7_1b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group3/M04/CF/F1/MTAuMTAuODguODQ=/6_162bb66c0dfg102SysCutcloud_98399597_7_1b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 15:09:52","score":0,"play_count":0,"time_length":178,"vid":98399597,"video_name":"巨石强森送葬者凯恩轮流暴虐小麦 哈哈哈求小麦的心理阴影面积","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M04/CF/F1/MTAuMTAuODguODQ=/6_162bb66c0dfg102SysCutcloud_98399597_7_1b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9437928,"album_name":"海外健身","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M07/D0/31/MTAuMTAuODguODE=/6_162bb6175bdg104SysCutcloudSrcimag_98399173_7_3b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M07/D0/31/MTAuMTAuODguODE=/6_162bb6175bdg104SysCutcloudSrcimag_98399173_7_3b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M07/D0/31/MTAuMTAuODguODE=/6_162bb6175bdg104SysCutcloudSrcimag_98399173_7_3b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M07/D0/31/MTAuMTAuODguODE=/6_162bb6175bdg104SysCutcloudSrcimag_98399173_7_3b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 15:00:34","score":0,"play_count":0,"time_length":281,"vid":98399173,"video_name":"国外各种极限运动失误, 简直不敢直视","video_desc":"国外各种极限运动失误,简直不敢直视","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M07/D0/31/MTAuMTAuODguODE=/6_162bb6175bdg104SysCutcloudSrcimag_98399173_7_3b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9437928,"album_name":"海外健身","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M02/D0/33/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MjkyNDUwODQ=/cut@m=force,w=240,h=330.png","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M02/D0/33/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MjkyNDUwODQ=/cut@m=force,w=240,h=180.png","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M02/D0/33/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MjkyNDUwODQ=/cut@m=force,w=160,h=90.png","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M02/D0/33/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MjkyNDUwODQ=/cut@m=force,w=160,h=90.png","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 15:00:34","score":0,"play_count":0,"time_length":189,"vid":98399226,"video_name":"国外街头健身没人关注, 在国内小迷妹都疯了吧","video_desc":"国外街头健身没人关注,在国内小迷妹都疯了吧","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M02/D0/33/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MjkyNDUwODQ=/cut@m=force,w=320,h=180.png"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/2B/MTAuMTAuODguODI=/6_162bb533a9fg104SysCutcloud_98398493_7_1b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/2B/MTAuMTAuODguODI=/6_162bb533a9fg104SysCutcloud_98398493_7_1b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/2B/MTAuMTAuODguODI=/6_162bb533a9fg104SysCutcloud_98398493_7_1b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/2B/MTAuMTAuODguODI=/6_162bb533a9fg104SysCutcloud_98398493_7_1b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 14:46:55","score":0,"play_count":0,"time_length":384,"vid":98398493,"video_name":"昨晚，韩国选手被差点绞晕，竟用出这招！直接被判犯规告负！","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M06/D0/2B/MTAuMTAuODguODI=/6_162bb533a9fg104SysCutcloud_98398493_7_1b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M03/D0/29/MTAuMTAuODguODI=/6_162bb4adb37g102SysCutcloud_98397971_7_0b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M03/D0/29/MTAuMTAuODguODI=/6_162bb4adb37g102SysCutcloud_98397971_7_0b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M03/D0/29/MTAuMTAuODguODI=/6_162bb4adb37g102SysCutcloud_98397971_7_0b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M03/D0/29/MTAuMTAuODguODI=/6_162bb4adb37g102SysCutcloud_98397971_7_0b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 14:39:16","score":0,"play_count":0,"time_length":81,"vid":98397971,"video_name":"重温经典之2014年索契冬奥会 短道速滑 女子500米 冠军李坚柔","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M03/D0/29/MTAuMTAuODguODI=/6_162bb4adb37g102SysCutcloud_98397971_7_0b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9437928,"album_name":"海外健身","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group3/M05/CF/B8/MTAuMTAuODguODM=/6_162baa483b5g102SysCutcloudSrcimag_98389933_7_0b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group3/M05/CF/B8/MTAuMTAuODguODM=/6_162baa483b5g102SysCutcloudSrcimag_98389933_7_0b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group3/M05/CF/B8/MTAuMTAuODguODM=/6_162baa483b5g102SysCutcloudSrcimag_98389933_7_0b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group3/M05/CF/B8/MTAuMTAuODguODM=/6_162baa483b5g102SysCutcloudSrcimag_98389933_7_0b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 11:35:17","score":0,"play_count":313,"time_length":169,"vid":98389933,"video_name":"国外人已经把水上极限运动玩出了新花样","video_desc":"国外人已经把水上极限运动玩出了新花样","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M05/CF/B8/MTAuMTAuODguODM=/6_162baa483b5g102SysCutcloudSrcimag_98389933_7_0b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9437928,"album_name":"海外健身","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/B8/MTAuMTAuODguODM=/6_162baa5033cg102SysCutcloudSrcimag_98389844_7_4b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/B8/MTAuMTAuODguODM=/6_162baa5033cg102SysCutcloudSrcimag_98389844_7_4b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/B8/MTAuMTAuODguODM=/6_162baa5033cg102SysCutcloudSrcimag_98389844_7_4b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/B8/MTAuMTAuODguODM=/6_162baa5033cg102SysCutcloudSrcimag_98389844_7_4b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 11:35:17","score":0,"play_count":640,"time_length":164,"vid":98389844,"video_name":"国外极限高空跳伞自由落体运动有趣精彩瞬间","video_desc":"国外极限高空跳伞自由落体运动有趣精彩瞬间","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/B8/MTAuMTAuODguODM=/6_162baa5033cg102SysCutcloudSrcimag_98389844_7_4b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M05/CF/F5/MTAuMTAuODguODI=/6_162ba9875f7g104SysCutcloud_98389413_7_0b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M05/CF/F5/MTAuMTAuODguODI=/6_162ba9875f7g104SysCutcloud_98389413_7_0b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M05/CF/F5/MTAuMTAuODguODI=/6_162ba9875f7g104SysCutcloud_98389413_7_0b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M05/CF/F5/MTAuMTAuODguODI=/6_162ba9875f7g104SysCutcloud_98389413_7_0b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 11:23:39","score":0,"play_count":17,"time_length":208,"vid":98389413,"video_name":"中国勇士金鹰的复仇之战，一拳正中对手面门","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M05/CF/F5/MTAuMTAuODguODI=/6_162ba9875f7g104SysCutcloud_98389413_7_0b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F5/MTAuMTAuODguODE=/6_162ba9733e5g104SysCutcloud_98389187_7_0b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F5/MTAuMTAuODguODE=/6_162ba9733e5g104SysCutcloud_98389187_7_0b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F5/MTAuMTAuODguODE=/6_162ba9733e5g104SysCutcloud_98389187_7_0b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F5/MTAuMTAuODguODE=/6_162ba9733e5g104SysCutcloud_98389187_7_0b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 11:21:56","score":0,"play_count":7,"time_length":243,"vid":98389187,"video_name":"刚刚，马拉特29秒KO播求大弟子苏波邦，强势登顶诸神总冠军！","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F5/MTAuMTAuODguODE=/6_162ba9733e5g104SysCutcloud_98389187_7_0b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9437928,"album_name":"海外健身","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/B2/MTAuMTAuODguODM=/6_162ba8ef85dg102SysCutcloud_98388751_7_7b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/B2/MTAuMTAuODguODM=/6_162ba8ef85dg102SysCutcloud_98388751_7_7b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/B2/MTAuMTAuODguODM=/6_162ba8ef85dg102SysCutcloud_98388751_7_7b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/B2/MTAuMTAuODguODM=/6_162ba8ef85dg102SysCutcloud_98388751_7_7b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 11:11:24","score":0,"play_count":5,"time_length":67,"vid":98388751,"video_name":"国外的体操比赛, 场面也不小","video_desc":"国外的体操比赛,场面也不小","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/B2/MTAuMTAuODguODM=/6_162ba8ef85dg102SysCutcloud_98388751_7_7b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9437928,"album_name":"海外健身","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F3/MTAuMTAuODguODE=/6_162ba8ddb43g102SysCutcloudSrcimag_98388747_7_1b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F3/MTAuMTAuODguODE=/6_162ba8ddb43g102SysCutcloudSrcimag_98388747_7_1b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F3/MTAuMTAuODguODE=/6_162ba8ddb43g102SysCutcloudSrcimag_98388747_7_1b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F3/MTAuMTAuODguODE=/6_162ba8ddb43g102SysCutcloudSrcimag_98388747_7_1b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 11:11:24","score":0,"play_count":7,"time_length":96,"vid":98388747,"video_name":"国外健身牛人单手引体向上, 小伙子你这是百年不遇的麒麟臂啊","video_desc":"国外健身牛人单手引体向上,小伙子你这是百年不遇的麒麟臂啊","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M01/CF/F3/MTAuMTAuODguODE=/6_162ba8ddb43g102SysCutcloudSrcimag_98388747_7_1b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M08/CF/EC/MTAuMTAuODguODE=/6_162ba7c7948g102SysCutcloud_98387975_7_1b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M08/CF/EC/MTAuMTAuODguODE=/6_162ba7c7948g102SysCutcloud_98387975_7_1b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M08/CF/EC/MTAuMTAuODguODE=/6_162ba7c7948g102SysCutcloud_98387975_7_1b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M08/CF/EC/MTAuMTAuODguODE=/6_162ba7c7948g102SysCutcloud_98387975_7_1b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 10:52:51","score":0,"play_count":6,"time_length":219,"vid":98387975,"video_name":"世界王者布洛克-莱斯纳尔被KO，宣布新的格斗时代到来了！","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M08/CF/EC/MTAuMTAuODguODE=/6_162ba7c7948g102SysCutcloud_98387975_7_1b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9437928,"album_name":"海外健身","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group3/M07/CF/A9/MTAuMTAuODguODM=/6_162ba78e4c8g104SysCutcloudSrcimag_98387560_7_2b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group3/M07/CF/A9/MTAuMTAuODguODM=/6_162ba78e4c8g104SysCutcloudSrcimag_98387560_7_2b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group3/M07/CF/A9/MTAuMTAuODguODM=/6_162ba78e4c8g104SysCutcloudSrcimag_98387560_7_2b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group3/M07/CF/A9/MTAuMTAuODguODM=/6_162ba78e4c8g104SysCutcloudSrcimag_98387560_7_2b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 10:46:09","score":0,"play_count":8,"time_length":159,"vid":98387560,"video_name":"国外健身教练的变态训练 全身运动","video_desc":"国外健身教练的变态训练全身运动","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M07/CF/A9/MTAuMTAuODguODM=/6_162ba78e4c8g104SysCutcloudSrcimag_98387560_7_2b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/9C/MTAuMTAuODguODM=/6_162ba48bd1cg104SysCutcloud_98385110_7_2b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/9C/MTAuMTAuODguODM=/6_162ba48bd1cg104SysCutcloud_98385110_7_2b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/9C/MTAuMTAuODguODM=/6_162ba48bd1cg104SysCutcloud_98385110_7_2b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/9C/MTAuMTAuODguODM=/6_162ba48bd1cg104SysCutcloud_98385110_7_2b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 09:56:02","score":0,"play_count":6,"time_length":266,"vid":98385110,"video_name":"压哨KO最后一秒放出大招回旋踢 造成对手10000点伤害秒杀","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M08/CF/9C/MTAuMTAuODguODM=/6_162ba48bd1cg104SysCutcloud_98385110_7_2b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/94/MTAuMTAuODguODM=/6_162ba2beabfg102SysCutcloud_98383515_7_3b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/94/MTAuMTAuODguODM=/6_162ba2beabfg102SysCutcloud_98383515_7_3b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/94/MTAuMTAuODguODM=/6_162ba2beabfg102SysCutcloud_98383515_7_3b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/94/MTAuMTAuODguODM=/6_162ba2beabfg102SysCutcloud_98383515_7_3b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 09:25:02","score":0,"play_count":24,"time_length":248,"vid":98383515,"video_name":"中国勇士历经40小时飞行远征巴西KO巴西名将 一拳让对手站着睡着","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M01/CF/94/MTAuMTAuODguODM=/6_162ba2beabfg102SysCutcloud_98383515_7_3b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group3/M09/CF/93/MTAuMTAuODguODQ=/6_162ba2799d4g102SysCutcloud_98383427_7_0b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group3/M09/CF/93/MTAuMTAuODguODQ=/6_162ba2799d4g102SysCutcloud_98383427_7_0b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group3/M09/CF/93/MTAuMTAuODguODQ=/6_162ba2799d4g102SysCutcloud_98383427_7_0b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group3/M09/CF/93/MTAuMTAuODguODQ=/6_162ba2799d4g102SysCutcloud_98383427_7_0b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 09:19:44","score":0,"play_count":32,"time_length":261,"vid":98383427,"video_name":"HHH霸气回归 复仇奥斯丁 恶劣态度时期下手有多狠？","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M09/CF/93/MTAuMTAuODguODQ=/6_162ba2799d4g102SysCutcloud_98383427_7_0b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9427477,"album_name":"搏击与极限","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/D3/MTAuMTAuODguODI=/6_162ba242428g104SysCutcloud_98383299_7_4b/cut@m=force,w=240,h=330.jpg","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/D3/MTAuMTAuODguODI=/6_162ba242428g104SysCutcloud_98383299_7_4b/cut@m=force,w=240,h=180.jpg","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/D3/MTAuMTAuODguODI=/6_162ba242428g104SysCutcloud_98383299_7_4b/cut@m=force,w=160,h=90.jpg","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/D3/MTAuMTAuODguODI=/6_162ba242428g104SysCutcloud_98383299_7_4b/cut@m=force,w=160,h=90.jpg","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 09:17:35","score":0,"play_count":6,"time_length":80,"vid":98383299,"video_name":"被奥运会耽误的段子手，王濛吐槽起韩国队一点都不含糊","video_desc":" ","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/D3/MTAuMTAuODguODI=/6_162ba242428g104SysCutcloud_98383299_7_4b/cut@m=force,w=320,h=180.jpg"},{"is_album":1,"is_trailer":0,"aid":9437928,"album_name":"海外健身","cid":28,"cate_code":"125104","ver_high_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/DB/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MDk4MzM0MTU=/cut@m=force,w=240,h=330.png","hor_high_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/DB/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MDk4MzM0MTU=/cut@m=force,w=240,h=180.png","hor_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/DB/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MDk4MzM0MTU=/cut@m=force,w=160,h=90.png","ver_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/DB/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MDk4MzM0MTU=/cut@m=force,w=160,h=90.png","latest_video_count":0,"total_video_count":0,"show_date":"2018-02-26 08:28:55","score":0,"play_count":2,"time_length":302,"vid":98381579,"video_name":"国外90后牛人攀爬上海中心大厦650米高空最高点 挑战极限","video_desc":"国外90后牛人攀爬上海中心大厦650米高空最高点挑战极限","site":2,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M02/CF/DB/MTAuMTAuODguODE=/MTAwMTE0XzE1MTk2MDk4MzM0MTU=/cut@m=force,w=320,h=180.png"}]
         */

        private int count;
        private List<VideosBean> videos;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<VideosBean> getVideos() {
            return videos;
        }

        public void setVideos(List<VideosBean> videos) {
            this.videos = videos;
        }

        public static class VideosBean implements Serializable {
            /**
             * is_album : 1
             * is_trailer : 0
             * aid : 9427477
             * album_name : 搏击与极限
             * cid : 28
             * cate_code : 125104
             * ver_high_pic : http://001.img.pu.sohu.com.cn/group2/M04/D0/34/MTAuMTAuODguODI=/6_162bb6dc603g102SysCutcloud_98400134_7_0b/cut@m=force,w=240,h=330.jpg
             * hor_high_pic : http://001.img.pu.sohu.com.cn/group2/M04/D0/34/MTAuMTAuODguODI=/6_162bb6dc603g102SysCutcloud_98400134_7_0b/cut@m=force,w=240,h=180.jpg
             * hor_pic : http://001.img.pu.sohu.com.cn/group2/M04/D0/34/MTAuMTAuODguODI=/6_162bb6dc603g102SysCutcloud_98400134_7_0b/cut@m=force,w=160,h=90.jpg
             * ver_pic : http://001.img.pu.sohu.com.cn/group2/M04/D0/34/MTAuMTAuODguODI=/6_162bb6dc603g102SysCutcloud_98400134_7_0b/cut@m=force,w=160,h=90.jpg
             * latest_video_count : 0
             * total_video_count : 0
             * show_date : 2018-02-26 15:18:02
             * score : 0
             * play_count : 0
             * time_length : 58
             * vid : 98400134
             * video_name : “中原飓风”闫西波TKO曾我英将，赛后姿势亮了连裁判都目瞪口呆
             * video_desc :
             * site : 2
             * hor_w8_pic : http://001.img.pu.sohu.com.cn/group2/M04/D0/34/MTAuMTAuODguODI=/6_162bb6dc603g102SysCutcloud_98400134_7_0b/cut@m=force,w=320,h=180.jpg
             */

            private int is_album;
            private int is_trailer;
            private int aid;
            private String album_name;
            private int cid;
            private String cate_code;
            private String ver_high_pic;
            private String hor_high_pic;
            private String hor_pic;
            private String ver_pic;
            private int latest_video_count;
            private int total_video_count;
            private String show_date;
            private int score;
            private int play_count;
            private int time_length;
            private int vid;
            private String video_name;
            private String video_desc;
            private int site;
            private String hor_w8_pic;

            public int getIs_album() {
                return is_album;
            }

            public void setIs_album(int is_album) {
                this.is_album = is_album;
            }

            public int getIs_trailer() {
                return is_trailer;
            }

            public void setIs_trailer(int is_trailer) {
                this.is_trailer = is_trailer;
            }

            public int getAid() {
                return aid;
            }

            public void setAid(int aid) {
                this.aid = aid;
            }

            public String getAlbum_name() {
                return album_name;
            }

            public void setAlbum_name(String album_name) {
                this.album_name = album_name;
            }

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public String getCate_code() {
                return cate_code;
            }

            public void setCate_code(String cate_code) {
                this.cate_code = cate_code;
            }

            public String getVer_high_pic() {
                return ver_high_pic;
            }

            public void setVer_high_pic(String ver_high_pic) {
                this.ver_high_pic = ver_high_pic;
            }

            public String getHor_high_pic() {
                return hor_high_pic;
            }

            public void setHor_high_pic(String hor_high_pic) {
                this.hor_high_pic = hor_high_pic;
            }

            public String getHor_pic() {
                return hor_pic;
            }

            public void setHor_pic(String hor_pic) {
                this.hor_pic = hor_pic;
            }

            public String getVer_pic() {
                return ver_pic;
            }

            public void setVer_pic(String ver_pic) {
                this.ver_pic = ver_pic;
            }

            public int getLatest_video_count() {
                return latest_video_count;
            }

            public void setLatest_video_count(int latest_video_count) {
                this.latest_video_count = latest_video_count;
            }

            public int getTotal_video_count() {
                return total_video_count;
            }

            public void setTotal_video_count(int total_video_count) {
                this.total_video_count = total_video_count;
            }

            public String getShow_date() {
                return show_date;
            }

            public void setShow_date(String show_date) {
                this.show_date = show_date;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getPlay_count() {
                return play_count;
            }

            public void setPlay_count(int play_count) {
                this.play_count = play_count;
            }

            public int getTime_length() {
                return time_length;
            }

            public void setTime_length(int time_length) {
                this.time_length = time_length;
            }

            public int getVid() {
                return vid;
            }

            public void setVid(int vid) {
                this.vid = vid;
            }

            public String getVideo_name() {
                return video_name;
            }

            public void setVideo_name(String video_name) {
                this.video_name = video_name;
            }

            public String getVideo_desc() {
                return video_desc;
            }

            public void setVideo_desc(String video_desc) {
                this.video_desc = video_desc;
            }

            public int getSite() {
                return site;
            }

            public void setSite(int site) {
                this.site = site;
            }

            public String getHor_w8_pic() {
                return hor_w8_pic;
            }

            public void setHor_w8_pic(String hor_w8_pic) {
                this.hor_w8_pic = hor_w8_pic;
            }
        }
    }
}
