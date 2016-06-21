package com.example.chenhaoyun.a2016_software_finalapp;

import java.util.Locale;

/**
 * Created by User on 2016/6/22.
 */
public class RestData {
    private String RestName , Locate , Locate2;
    private double PosX  , PosY;
    public RestData(){
        RestName = "HIHI";
        Locate = "HIHI";
        Locate2 = "QQ";
        PosX = 25.222222;
        PosY = 121.333333;
    }
    public RestData(String L,String H,String n , double x , double y){
        RestName = n;
        Locate = L;
        Locate2 = H;
        PosX = x;
        PosY = y;
    }
    public void setLocate(String n){Locate = n;}
    public void setRestName(String n){RestName = n;}
    public void setPosX(double x){PosX = x;}
    public void setPosY(double y){PosY = y;}
    public String getLocate(){return Locate;}
    public String getLocate2(){return Locate2;}
    public String getRestName(){return RestName ;}
    public double getPosX() { return PosX ; }
    public double getPosY() {return PosY;}
    public RestData[] setALL(){
        RestData[] all = new RestData[23];
        all[0] = new RestData("Taipei","Taipei", "古拉爵義式屋",25.054395,121.525580);
        all[1] = new RestData("Taipei","New Taipei","HANA日本料理",25.003266,121.514803);
        all[2] = new RestData("Taipei","Ilan","德國農夫廚房",25.000414,121.552250);
        all[3] = new RestData("New Taipei","Taoyuan","榕堤水灣餐廳",25.171759,121.436791);
        all[4] = new RestData("New Taipei","New Taipei","榕堤水灣餐廳",25.171759,121.436791);
        all[5] = new RestData("Taoyuan","Taoyuan","托斯卡尼尼",25.015736,121.298785);
        all[6] = new RestData("Taoyuan","Hsinchu","夏慕尼",24.830522,121.017137);
        all[7] = new RestData("Hsinchu","Hsinchu","清大小ㄘ部",24.792872, 120.993118);
        all[8] = new RestData("Hsinchu","Miaoli","艾蜜奇義大利坊",24.682702, 120.868951);
        all[9] = new RestData("Miaoli","Miaoli","漫步雲端森林廚房",24.383892, 120.801920);
        all[10] = new RestData("Miaoli","Taichung","饗食天堂(台中店)",24.165166, 120.644749);
        all[11] = new RestData("Taichung","Taichung","饗食天堂(台中店)",24.165166, 120.644749);
        all[12] = new RestData("Chunghua","Taichung","饗食天堂(台中店)",24.165166, 120.644749);
        all[13] = new RestData("Chunghua","Chunghua","全得玫瑰莊園",23.906368, 120.528329);
        all[14] = new RestData("Chunghua","Yunlin","全得玫瑰莊園",23.906368, 120.528329);
        all[15] = new RestData("Yunlin","Yunlin","松竹屋日本料理",23.713108, 120.542165);
        all[16] = new RestData("Yunlin","Chiayi","老洋房1931",23.480064, 120.446365);
        all[17] = new RestData("Chiayi","Tainan","ISABATI義式料理",23.017043, 120.235290);
        all[18] = new RestData("Tainan","Tainan","ISABATI義式料理",23.017043, 120.235290);
        all[19] = new RestData("Kaohsiung","Tainan","韓食堂哈摩尼",22.665672, 120.307232);
        all[20] = new RestData("Kaohsiung","Kaohsiung","韓食堂哈摩尼",22.665672, 120.307232);
        all[21] = new RestData("Kaohsiung","Pingtung","FrenchWindows ",22.674089, 120.489736);
        all[22] = new RestData("Pingtung","Pingtung","FrenchWindows ",22.674089, 120.489736);
        return all;
    }
    public RestData find(String A , String B, RestData[] all){
        int i;
        RestData not_found = new RestData("QQ","QQ","QQ",25.111111,121.422222);
        for(RestData R : all){
            System.out.println("Rest finder  " +R.getLocate() + "   " + R.getLocate2());
            if( (R.Locate.equals(A) && R.Locate2.equals(B) )||(R.Locate2.equals(A) && R.Locate.equals(B)) ){
                return R;
            }
        }
        return not_found;
    }
}
