package com.cookandroid.studyassist_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TodolistActivity extends AppCompatActivity {
    CheckBox tdCb1, tdCb2, tdCb3, tdCb4, tdCb5, tdCb6;
    TextView tdMainTv1, tdMainTv2, tdMainTv3, tdMainTv4, tdMainTv5, tdMainTv6;
    TextView tdSubTv1, tdSubTv2, tdSubTv3, tdSubTv4, tdSubTv5, tdSubTv6;
    Button tdBtn1,tdBtn2,tdBtn3,tdBtn4,tdBtn5,tdBtn6;

    EditText tdTitle1,tdTitle2,tdTitle3,tdTitle4,tdTitle5,tdTitle6;
    EditText tdContent1,tdContent2,tdContent3,tdContent4,tdContent5,tdContent6;

    View dialogView1,dialogView2,dialogView3,dialogView4,dialogView5,dialogView6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        //setTitle("투두리스트");
        tdCb1=(CheckBox)findViewById(R.id.tdCb1);
        tdCb2=(CheckBox)findViewById(R.id.tdCb2);
        tdCb3=(CheckBox)findViewById(R.id.tdCb3);
        tdCb4=(CheckBox)findViewById(R.id.tdCb4);
        tdCb5=(CheckBox)findViewById(R.id.tdCb5);
        tdCb6=(CheckBox)findViewById(R.id.tdCb6);

        tdMainTv1=(TextView)findViewById(R.id.tdMainTv1);
        tdMainTv2=(TextView)findViewById(R.id.tdMainTv2);
        tdMainTv3=(TextView)findViewById(R.id.tdMainTv3);
        tdMainTv4=(TextView)findViewById(R.id.tdMainTv4);
        tdMainTv5=(TextView)findViewById(R.id.tdMainTv5);
        tdMainTv6=(TextView)findViewById(R.id.tdMainTv6);

        tdBtn1=(Button)findViewById(R.id.tdBtn1);
        tdBtn2=(Button)findViewById(R.id.tdBtn2);
        tdBtn3=(Button)findViewById(R.id.tdBtn3);
        tdBtn4=(Button)findViewById(R.id.tdBtn4);
        tdBtn5=(Button)findViewById(R.id.tdBtn5);
        tdBtn6=(Button)findViewById(R.id.tdBtn6);


        //대화상자1
        tdBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView1=(View) View.inflate(TodolistActivity.this,R.layout.td_dialog1,null);
                AlertDialog.Builder dlg1=new AlertDialog.Builder(TodolistActivity.this);
                dlg1.setTitle("일정을 추가해주세요!");
                dlg1.setView(dialogView1);

                //확인버튼 매서드(제목 내용 입력)
                dlg1.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tdTitle1=(EditText) dialogView1.findViewById(R.id.tdTitle1);
                        tdContent1=(EditText) dialogView1.findViewById(R.id.tdContent1);
                        tdMainTv1.setText(tdTitle1.getText().toString()+" : "+tdContent1.getText().toString());
                    }
                });
                dlg1.setNegativeButton("취소",null);
                dlg1.show();
            }
        });
        //체크박스 체크 메서드1
        tdCb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tdCb1.isChecked()) {
                    tdMainTv1.setPaintFlags(tdMainTv1.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
                    tdMainTv1.setTextColor(Color.RED);
                }
            }
        });

        //대화상자2
        tdBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView2=(View) View.inflate(TodolistActivity.this,R.layout.td_dialog2,null);
                AlertDialog.Builder dlg2=new AlertDialog.Builder(TodolistActivity.this);
                dlg2.setTitle("일정을 추가해주세요!");
                dlg2.setView(dialogView2);

                //확인버튼 매서드(제목 내용 입력)
                dlg2.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tdTitle2=(EditText) dialogView2.findViewById(R.id.tdTitle2);
                        tdContent2=(EditText) dialogView2.findViewById(R.id.tdContent2);
                        tdMainTv2.setText(tdTitle2.getText().toString()+" : "+tdContent2.getText().toString());
                    }
                });
                dlg2.setNegativeButton("취소",null);
                dlg2.show();
            }
        });
        //체크박스 체크 메서드2
        tdCb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tdCb2.isChecked()) {
                    tdMainTv2.setPaintFlags(tdMainTv2.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
                    tdMainTv2.setTextColor(Color.RED);
                }
            }
        });

        //대화상자3
        tdBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView3=(View) View.inflate(TodolistActivity.this,R.layout.td_dialog3,null);
                AlertDialog.Builder dlg3=new AlertDialog.Builder(TodolistActivity.this);
                dlg3.setTitle("일정을 추가해주세요!");
                dlg3.setView(dialogView3);

                //확인버튼 매서드(제목 내용 입력)
                dlg3.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tdTitle3=(EditText) dialogView3.findViewById(R.id.tdTitle3);
                        tdContent3=(EditText) dialogView3.findViewById(R.id.tdContent3);
                        tdMainTv3.setText(tdTitle3.getText().toString()+" : "+tdContent3.getText().toString());
                    }
                });
                dlg3.setNegativeButton("취소",null);
                dlg3.show();
            }
        });
        //체크박스 체크 메서드3
        tdCb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tdCb3.isChecked()) {
                    tdMainTv3.setPaintFlags(tdMainTv3.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
                    tdMainTv3.setTextColor(Color.RED);
                }
            }
        });

        //대화상자4
        tdBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView4=(View) View.inflate(TodolistActivity.this,R.layout.td_dialog4,null);
                AlertDialog.Builder dlg4=new AlertDialog.Builder(TodolistActivity.this);
                dlg4.setTitle("일정을 추가해주세요!");
                dlg4.setView(dialogView4);

                //확인버튼 매서드(제목 내용 입력)
                dlg4.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tdTitle4=(EditText) dialogView4.findViewById(R.id.tdTitle4);
                        tdContent4=(EditText) dialogView4.findViewById(R.id.tdContent4);
                        tdMainTv4.setText(tdTitle4.getText().toString()+" : "+tdContent4.getText().toString());
                    }
                });
                dlg4.setNegativeButton("취소",null);
                dlg4.show();
            }
        });
        //체크박스 체크 메서드4
        tdCb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tdCb4.isChecked()) {
                    tdMainTv4.setPaintFlags(tdMainTv4.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
                    tdMainTv4.setTextColor(Color.RED);
                }
            }
        });

        //대화상자5
        tdBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView5=(View) View.inflate(TodolistActivity.this,R.layout.td_dialog5,null);
                AlertDialog.Builder dlg5=new AlertDialog.Builder(TodolistActivity.this);
                dlg5.setTitle("일정을 추가해주세요!");
                dlg5.setView(dialogView5);

                //확인버튼 매서드(제목 내용 입력)
                dlg5.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tdTitle5=(EditText) dialogView5.findViewById(R.id.tdTitle5);
                        tdContent5=(EditText) dialogView5.findViewById(R.id.tdContent5);
                        tdMainTv5.setText(tdTitle5.getText().toString()+ " : " + tdContent5.getText().toString());
                    }
                });
                dlg5.setNegativeButton("취소",null);
                dlg5.show();
            }
        });
        //체크박스 체크 메서드5
        tdCb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tdCb5.isChecked()) {
                    tdMainTv5.setPaintFlags(tdMainTv5.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
                    tdMainTv5.setTextColor(Color.RED);
                }
            }
        });

        //대화상자6
        tdBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView6=(View) View.inflate(TodolistActivity.this,R.layout.td_dialog6,null);
                AlertDialog.Builder dlg6=new AlertDialog.Builder(TodolistActivity.this);
                dlg6.setTitle("일정을 추가해주세요!");
                dlg6.setView(dialogView6);

                //확인버튼 매서드(제목 내용 입력)
                dlg6.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tdTitle6=(EditText) dialogView6.findViewById(R.id.tdTitle6);
                        tdContent6=(EditText) dialogView6.findViewById(R.id.tdContent6);
                        tdMainTv6.setText(tdTitle6.getText().toString()+" : "+tdContent6.getText().toString());
                    }
                });
                dlg6.setNegativeButton("취소",null);
                dlg6.show();
            }
        });
        //체크박스 체크 메서드6
        tdCb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tdCb6.isChecked()) {
                    tdMainTv6.setPaintFlags(tdMainTv6.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
                    tdMainTv6.setTextColor(Color.RED);
                }
            }
        });


    }
}