package com.edu.ntou.smartcampus.Theme;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import com.edu.ntou.smartcampus.R;

public class SiteInforActivity extends AppCompatActivity{

    private ImageButton ib01, ib03, ib04, ib05, ib07, ib08, ib09, ib10, ib12 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_infor);

        ib01 = (ImageButton) findViewById(R.id.ib01);

        ib03 = (ImageButton) findViewById(R.id.ib03);
        ib04 = (ImageButton) findViewById(R.id.ib04);
        ib05 = (ImageButton) findViewById(R.id.ib05);
        ib07 = (ImageButton) findViewById(R.id.ib07);
        ib08 = (ImageButton) findViewById(R.id.ib08);
        ib09 = (ImageButton) findViewById(R.id.ib09);
        ib10 = (ImageButton) findViewById(R.id.ib10);

        ib12 = (ImageButton) findViewById(R.id.ib12);

        ib01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SiteInforActivity.this)
                        .setTitle("操場")

                        .setMessage("開放時間: 上午六時下午十時止\n" +
                                "地點:海洋大學北寧路旁\n" +
                                "簡介:\n" +
                                "使用本運動場，須遵守下列各項規定：\n" +
                                "一、非特殊需要禁止腳踏車、摩托車與汽車等車輛進入場區。\n" +
                                "二、禁止亂丟垃圾、抽煙、喝酒等違反社會秩序之行為。\n" +
                                "三、禁止棒球活動，以維護其他人員之安全。\n" +
                                "四、使用均應愛惜相關場地設施，禁止所有違反場地性質活動與行\n" +
                                "　　為，如有損壞應照價賠償。\n")
                        .show();
            }
        });
        ib03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(SiteInforActivity.this);
                LayoutInflater factory = LayoutInflater.from(SiteInforActivity.this);
                final View view = factory.inflate(R.layout.alertdialog11, null);
                alertadd.setView(view);
                        alertadd.setTitle("育樂館");

                alertadd.setMessage("開放時間: \n" +
                        "   週一至週五06：00~22：10。(06：00~08：10為系隊使用時段)。\n" +
                        "　 國定假日不開放，寒暑假時間另訂。\n" +
                        "　 如配合學校活動及遇其它特殊事項而影響開放時間，將另行公告。\n" + "\n"+
                        "地點:海洋大學商船系館對面\n"+ "\n"+
                        "內部景觀");

                alertadd.show();
            }
        });
        ib04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SiteInforActivity.this)
                        .setTitle("祥豐室外網球場")
                        .setMessage("開放時間: 六時下午十時止\n" +
                                "地點:海洋大學祥豐校門附近(生命科學院館旁)\n" +
                                "簡介:\n" +
                                "使用本球場，須遵守下列各項規定：\n" +
                                "一、非特殊需要禁止腳踏 車、直排輪、溜冰鞋等進入場區，避免破\n" +
                                "　　壞場地。\n" +
                                "二、禁止亂丟垃圾、抽煙、喝酒等違反社會秩序之行為。\n" +
                                "三、禁止棒壘球活動，以維護 其他人員之安全。\n" +
                                "四、使用均應愛惜相關場地設施，禁止所有違反場地性質活動與行\n" +
                                "　　為，如有損壞應照價賠償。\n")
                        .show();
            }
        });
        ib05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SiteInforActivity.this)
                        .setTitle("濱海籃球場")
                        .setMessage("開放時間: 上午六時下午十時止\n" +
                                "地點:海洋大學北寧路旁(近濱海校門)\n" +
                                "簡介:\n" +
                                "使用本運動場，須遵守下列各項規定：\n" +
                                "一、非特殊需要禁止腳踏車、摩托車與汽車等車輛進入場區。\n" +
                                "二、禁止亂丟垃圾、抽煙、喝酒等違反社會秩序之行為。\n" +
                                "三、禁止棒球活動，以維護其他人員之安全。\n" +
                                "四、使用均應愛惜相關場地設施，禁止所有違反場地性質活動與行\n" +
                                "　　為，如有損壞應照價賠償。\n")
                        .show();
            }
        });
        ib07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SiteInforActivity.this)
                        .setTitle("紅土壘球場")
                        .setMessage("開放時間:無特別規定\n" +
                                "地點: 海洋大學工學院後方濱海區\n" +
                                "簡介:\n" +
                                "在打壘球的同時，還可以看海、吹海風的好地方。\n")
                        .show();
            }
        });
        ib08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SiteInforActivity.this)
                        .setTitle("沙灘排球場")
                        .setMessage("開放時間:無特別規定\n" +
                                "地點: 海洋大學工學院後方濱海區\n" +
                                "簡介: \n" +
                                "全國唯一一個可以「聽海浪聲、看海、吹海風、晚上躺著看月亮、數星星」的大學校園人工沙灘排球場。共有兩面排球場，鋪設40公分厚白色細沙，長40公尺、寬50公尺，除了可以打沙灘排球之外，還可以打沙灘手球及踢沙灘足球。\n")
                        .show();
            }
        });
        ib09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(SiteInforActivity.this);
                LayoutInflater factory = LayoutInflater.from(SiteInforActivity.this);
                final View view = factory.inflate(R.layout.alertdialog02, null);
                alertadd.setView(view);
                alertadd.setTitle("游泳池");
                 alertadd.setMessage("開放時間: 全年開放\n" +"\n"+"地點:海洋大學男二舍對面\n"+"\n"+
                        "內部景觀");
                alertadd.show();
            }
        });
        ib10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SiteInforActivity.this)
                        .setTitle("體育館外部")
                        .setMessage("開放時間: 學期上課期間為每週一至週五08：20～22：00(只限本校教職學生使用)；例假日及寒暑假期間為11：00～21：00。\n" +
                                "（健身房每週一至週五12：10～13：10、17：10～22：10；例假日及寒暑假期間為11：00～14：00、17：00～21：00）。\n" +
                                "校外人士使用時間為例假日及寒暑假期間且單次單時收費。\n" +
                                "\n"+
                                "地點:海洋大學操場旁(近OK便利商店)\n" +
                                "\n"+
                                "簡介:\n" +
                                "\n"+
                                "包含健身房、韻律教室、桌球教室、羽球教室、網球教室、室內跑道\n" +
                                "\n"+
                                "收費時段：\n" +
                                "\n"+
                                "學期上課期間為週一至週五中午12：10～13：10、下午17：10～22：10；例假日及寒暑假期間11：00～21：00，使用時需出示運動證或繳費收據始得進入場區運動。其他經獲核准者不在此限。校內教職員工生、眷屬及校友使用場館時未出示證明文件一律以校外人士計費。（健身房開放時間皆為收費時段）\n" +
                                "1.已繳交年費者，憑收據至體育室活動組製發運動證。\n" +
                                "2.全校性運動團體之例行性活動需個別辦證或繳費，並以團體使用為原則。\n" +
                                "3.校外機關團體「國立台灣海洋大學場地及設施管理借用辦法」辦理借用。\n" +
                                "4.韻律教室10人(含)以上始得借用。\n" +
                                "5.交換學生、大四生及碩士班，依實際使用情形申辦半年證 ( 以半價收費 )。\n" +
                                "6.羽球教室、桌球教室及網球教室，若校外人士與校內教職員工生一同使用同場地，需支付1/4場地費用。\n" +
                                "7.辦理三年(含)以上長期使用證者，享7 折惠。\n" +
                                "8.中正區里民憑身分證7折優惠。\n" +
                                "9.運動證因故損壞或遺失者，可至體育室辦理補證，第一次無須收費，第二次需酌收工本費用新台幣50元整。\n")
                        .show();
            }
        });
        ib12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SiteInforActivity.this)
                        .setTitle("祥豐室外排球場")
                        .setMessage("開放時間: 六時下午十時止\n" +
                                "地點:海洋大學祥豐校門附近(生命科學院館旁)\n" +
                                "簡介:\n" +
                                "使用本球場，須遵守下列各項規定：\n" +
                                "一、非特殊需要禁止腳踏 車、直排輪、溜冰鞋等進入場區，避免破\n" +
                                "　　壞場地。\n" +
                                "二、禁止亂丟垃圾、抽煙、喝酒等違反社會秩序之行為。\n" +
                                "三、禁止棒壘球活動，以維護 其他人員之安全。\n" +
                                "四、使用均應愛惜相關場地設施，禁止所有違反場地性質活動與行\n" +
                                "為，如有損壞應照價賠償。\n")
                        .show();
            }
        });
    }

}