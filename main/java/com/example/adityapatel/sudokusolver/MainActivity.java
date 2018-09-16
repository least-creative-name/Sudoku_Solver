package com.example.adityapatel.sudokusolver;

import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static cell [][] matrix = new cell[9][9];
    int [][]sizes = new int[9][9];
    public static final Button [][]grid = new Button[9][9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        grid[0][0] = (Button) findViewById(R.id.grid00);
        grid[0][1] = (Button) findViewById(R.id.grid01);
        grid[0][2] = (Button) findViewById(R.id.grid02);
        grid[0][3] = (Button) findViewById(R.id.grid03);
        grid[0][4] = (Button) findViewById(R.id.grid04);
        grid[0][5] = (Button) findViewById(R.id.grid05);
        grid[0][6] = (Button) findViewById(R.id.grid06);
        grid[0][7] = (Button) findViewById(R.id.grid07);
        grid[0][8] = (Button) findViewById(R.id.grid08);

        grid[1][0] = (Button) findViewById(R.id.grid10);
        grid[1][1] = (Button) findViewById(R.id.grid11);
        grid[1][2] = (Button) findViewById(R.id.grid12);
        grid[1][3] = (Button) findViewById(R.id.grid13);
        grid[1][4] = (Button) findViewById(R.id.grid14);
        grid[1][5] = (Button) findViewById(R.id.grid15);
        grid[1][6] = (Button) findViewById(R.id.grid16);
        grid[1][7] = (Button) findViewById(R.id.grid17);
        grid[1][8] = (Button) findViewById(R.id.grid18);

        grid[2][0] = (Button) findViewById(R.id.grid20);
        grid[2][1] = (Button) findViewById(R.id.grid21);
        grid[2][2] = (Button) findViewById(R.id.grid22);
        grid[2][3] = (Button) findViewById(R.id.grid23);
        grid[2][4] = (Button) findViewById(R.id.grid24);
        grid[2][5] = (Button) findViewById(R.id.grid25);
        grid[2][6] = (Button) findViewById(R.id.grid26);
        grid[2][7] = (Button) findViewById(R.id.grid27);
        grid[2][8] = (Button) findViewById(R.id.grid28);

        grid[3][0] = (Button) findViewById(R.id.grid30);
        grid[3][1] = (Button) findViewById(R.id.grid31);
        grid[3][2] = (Button) findViewById(R.id.grid32);
        grid[3][3] = (Button) findViewById(R.id.grid33);
        grid[3][4] = (Button) findViewById(R.id.grid34);
        grid[3][5] = (Button) findViewById(R.id.grid35);
        grid[3][6] = (Button) findViewById(R.id.grid36);
        grid[3][7] = (Button) findViewById(R.id.grid37);
        grid[3][8] = (Button) findViewById(R.id.grid38);

        grid[4][0] = (Button) findViewById(R.id.grid40);
        grid[4][1] = (Button) findViewById(R.id.grid41);
        grid[4][2] = (Button) findViewById(R.id.grid42);
        grid[4][3] = (Button) findViewById(R.id.grid43);
        grid[4][4] = (Button) findViewById(R.id.grid44);
        grid[4][5] = (Button) findViewById(R.id.grid45);
        grid[4][6] = (Button) findViewById(R.id.grid46);
        grid[4][7] = (Button) findViewById(R.id.grid47);
        grid[4][8] = (Button) findViewById(R.id.grid48);

        grid[5][0] = (Button) findViewById(R.id.grid50);
        grid[5][1] = (Button) findViewById(R.id.grid51);
        grid[5][2] = (Button) findViewById(R.id.grid52);
        grid[5][3] = (Button) findViewById(R.id.grid53);
        grid[5][4] = (Button) findViewById(R.id.grid54);
        grid[5][5] = (Button) findViewById(R.id.grid55);
        grid[5][6] = (Button) findViewById(R.id.grid56);
        grid[5][7] = (Button) findViewById(R.id.grid57);
        grid[5][8] = (Button) findViewById(R.id.grid58);

        grid[6][0] = (Button) findViewById(R.id.grid60);
        grid[6][1] = (Button) findViewById(R.id.grid61);
        grid[6][2] = (Button) findViewById(R.id.grid62);
        grid[6][3] = (Button) findViewById(R.id.grid63);
        grid[6][4] = (Button) findViewById(R.id.grid64);
        grid[6][5] = (Button) findViewById(R.id.grid65);
        grid[6][6] = (Button) findViewById(R.id.grid66);
        grid[6][7] = (Button) findViewById(R.id.grid67);
        grid[6][8] = (Button) findViewById(R.id.grid68);

        grid[7][0] = (Button) findViewById(R.id.grid70);
        grid[7][1] = (Button) findViewById(R.id.grid71);
        grid[7][2] = (Button) findViewById(R.id.grid72);
        grid[7][3] = (Button) findViewById(R.id.grid73);
        grid[7][4] = (Button) findViewById(R.id.grid74);
        grid[7][5] = (Button) findViewById(R.id.grid75);
        grid[7][6] = (Button) findViewById(R.id.grid76);
        grid[7][7] = (Button) findViewById(R.id.grid77);
        grid[7][8] = (Button) findViewById(R.id.grid78);

        grid[8][0] = (Button) findViewById(R.id.grid80);
        grid[8][1] = (Button) findViewById(R.id.grid81);
        grid[8][2] = (Button) findViewById(R.id.grid82);
        grid[8][3] = (Button) findViewById(R.id.grid83);
        grid[8][4] = (Button) findViewById(R.id.grid84);
        grid[8][5] = (Button) findViewById(R.id.grid85);
        grid[8][6] = (Button) findViewById(R.id.grid86);
        grid[8][7] = (Button) findViewById(R.id.grid87);
        grid[8][8] = (Button) findViewById(R.id.grid88);

        final Button [] choice = new Button[10];

        choice [0] = (Button) findViewById(R.id.blank);
        choice [1] = (Button) findViewById(R.id.choice1);
        choice [2] = (Button) findViewById(R.id.choice2);
        choice [3] = (Button) findViewById(R.id.choice3);
        choice [4] = (Button) findViewById(R.id.choice4);
        choice [5] = (Button) findViewById(R.id.choice5);
        choice [6] = (Button) findViewById(R.id.choice6);
        choice [7] = (Button) findViewById(R.id.choice7);
        choice [8] = (Button) findViewById(R.id.choice8);
        choice [9] = (Button) findViewById(R.id.choice9);

        final Button lock;
        lock = (Button) findViewById(R.id.lock);


        final Button reset = (Button) findViewById(R.id.findOptions);
        final Button solve = (Button) findViewById(R.id.solve);
        final Button go2camera = (Button) findViewById(R.id.go2camera);



        for (int i =0; i<10; i++) {
            choice [i].setEnabled(false);
            choice [i].setVisibility(View.INVISIBLE);
        }



        grid[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[0][0].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[0][0].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }



            }
        });

        grid[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[0][1].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[0][1].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }

            }
        });

        grid[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[0][2].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[0][2].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });

        grid[0][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[0][3].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[0][3].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }



            }
        });

        grid[0][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[0][4].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[0][4].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });

        grid[0][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[0][5].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[0][5].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });

        grid[0][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[0][6].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[0][6].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }

            }
        });
        grid[0][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[0][7].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[0][7].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[0][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[0][8].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[0][8].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[1][0].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[1][0].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[1][1].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[1][1].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }

            }
        });
        grid[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[1][2].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[1][2].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[1][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[1][3].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[1][3].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[1][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[1][4].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[1][4].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[1][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[1][5].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[1][5].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[1][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[1][6].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[1][6].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }

            }
        });
        grid[1][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[1][7].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[1][7].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[1][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[1][8].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[1][8].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[2][0].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[2][0].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[2][1].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[2][1].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[2][2].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[2][2].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[2][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[2][3].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[2][3].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[2][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[2][4].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[2][4].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[2][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[2][5].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[2][5].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[2][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[2][6].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[2][6].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[2][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[2][7].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[2][7].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[2][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[2][8].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[2][8].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[3][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[3][0].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[3][0].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[3][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[3][1].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[3][1].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[3][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[3][2].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[3][2].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[3][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[3][3].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[3][3].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }

            }
        });
        grid[3][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[3][4].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[3][4].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[3][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[3][5].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[3][5].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[3][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[3][6].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[3][6].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[3][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[3][7].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[3][7].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[3][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[3][8].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[3][8].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[4][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[4][0].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[4][0].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[4][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[4][1].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[4][1].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[4][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[4][2].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[4][2].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[4][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[4][3].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[4][3].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[4][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[4][4].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[4][4].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[4][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[4][5].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[4][5].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }

            }
        });
        grid[4][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[4][6].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[4][6].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[4][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[4][7].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[4][7].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[4][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[4][8].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[4][8].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[5][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[5][0].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[5][0].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[5][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[5][1].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[5][1].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[5][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[5][2].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[5][2].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[5][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[5][3].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[5][3].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[5][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[5][4].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[5][4].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[5][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[5][5].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[5][5].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[5][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[5][6].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[5][6].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }



            }
        });
        grid[5][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[5][7].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[5][7].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }



            }
        });
        grid[5][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[5][8].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[5][8].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[6][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[6][0].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[6][0].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }

            }
        });
        grid[6][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[6][1].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[6][1].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[6][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[6][2].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[6][2].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[6][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[6][3].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[6][3].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[6][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[6][4].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[6][4].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }

            }
        });
        grid[6][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[6][5].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[6][5].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[6][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[6][6].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[6][6].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[6][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[6][7].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[6][7].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[6][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[6][8].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[6][8].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }

            }
        });
        grid[7][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[7][0].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[7][0].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[7][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[7][1].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[7][1].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[7][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[7][2].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[7][2].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }

            }
        });
        grid[7][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[7][3].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[7][3].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }

            }
        });
        grid[7][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[7][4].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[7][4].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }

            }
        });
        grid[7][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[7][5].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[7][5].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }

            }
        });
        grid[7][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[7][6].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[7][6].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[7][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[7][7].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[7][7].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[7][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[7][8].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[7][8].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[8][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[8][0].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[8][0].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[8][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[8][1].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[8][1].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[8][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[8][2].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[8][2].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[8][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[8][3].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[8][3].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }

            }
        });
        grid[8][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[8][4].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[8][4].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }

            }
        });
        grid[8][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[8][5].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[8][5].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }

            }
        });
        grid[8][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[8][6].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[8][6].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[8][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[8][7].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[8][7].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });
        grid[8][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[8][8].setBackgroundColor(Color.parseColor("#FCF3CF"));
                grid[8][8].setTextColor( Color.parseColor("#17202A"));
                for (int i =0; i<10; i++) {
                    choice [i].setEnabled(true);
                    choice [i].setVisibility(View.VISIBLE);
                }


            }
        });

        for(int i =0; i<9; i++){
            for (int j=0; j<9; j++){
                matrix[i][j] = new cell();
            }
        }

        for(int i = 0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                sizes[i][j] = matrix[i][j].getSize();
            }
        }


        choice[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i =0; i<9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if( grid[i][j].getCurrentTextColor() == Color.parseColor("#17202A") ) {
                            grid[i][j].setText(" ");
                            //block[i][j].setInput_value( );

                            if((j<=2 &(i<3 | i>5)) | ( (i>=3 & i<=5) &(j>=3 & j<=5) ) | (j>5 &(i<3 | i>5)))
                                grid[i][j].setBackgroundColor(Color.parseColor("#BCC6CC"));
                            else
                                grid[i][j].setBackgroundColor(Color.parseColor("#FFFFFF"));
                            grid[i][j].setTextColor(Color.BLACK);
                            matrix[i][j].eraseInput_Value();

                        }
                    }
                }
                for (int k =0; k<10; k++) {
                    choice [k].setEnabled(false);
                    choice [k].setVisibility(View.INVISIBLE);
                }

            }
        });

        choice[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i =0; i<9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if( grid[i][j].getCurrentTextColor() == Color.parseColor("#17202A") ) {
                            grid[i][j].setText("1");
                            //block[i][j].setInput_value(1);

                            if((j<=2 &(i<3 | i>5)) | ( (i>=3 & i<=5) &(j>=3 & j<=5) ) | (j>5 &(i<3 | i>5)))
                                grid[i][j].setBackgroundColor(Color.parseColor("#BCC6CC"));
                            else
                                grid[i][j].setBackgroundColor(Color.parseColor("#FFFFFF"));
                            grid[i][j].setTextColor(Color.BLACK);
                            matrix[i][j].setInput_Value(1);

                        }
                    }
                }
                for (int k =0; k<10; k++) {
                    choice [k].setEnabled(false);
                    choice [k].setVisibility(View.INVISIBLE);
                }

            }
        });
        choice[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i =0; i<9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if( grid[i][j].getCurrentTextColor() == Color.parseColor("#17202A") ) {
                            grid[i][j].setText("2");
                            //block[i][j].setInput_value(2);
                            if((j<=2 &(i<3 | i>5)) | ( (i>=3 & i<=5) &(j>=3 & j<=5) ) | (j>5 &(i<3 | i>5)))
                                grid[i][j].setBackgroundColor(Color.parseColor("#BCC6CC"));
                            else
                                grid[i][j].setBackgroundColor(Color.parseColor("#FFFFFF"));
                            grid[i][j].setTextColor(Color.BLACK);
                            matrix[i][j].setInput_Value(2);

                        }
                    }
                }
                for (int k =0; k<10; k++) {
                    choice [k].setEnabled(false);
                    choice [k].setVisibility(View.INVISIBLE);
                }

            }
        });
        choice[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i =0; i<9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if( grid[i][j].getCurrentTextColor() == Color.parseColor("#17202A") ) {
                            grid[i][j].setText("3");
                            //block[i][j].setInput_value(3);
                            if((j<=2 &(i<3 | i>5)) | ( (i>=3 & i<=5) &(j>=3 & j<=5) ) | (j>5 &(i<3 | i>5)))
                                grid[i][j].setBackgroundColor(Color.parseColor("#BCC6CC"));
                            else
                                grid[i][j].setBackgroundColor(Color.parseColor("#FFFFFF"));
                            grid[i][j].setTextColor(Color.BLACK);
                            matrix[i][j].setInput_Value(3);



                        }
                    }
                }
                for (int k =0; k<10; k++) {
                    choice [k].setEnabled(false);
                    choice [k].setVisibility(View.INVISIBLE);
                }

            }
        });
        choice[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i =0; i<9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if( grid[i][j].getCurrentTextColor() == Color.parseColor("#17202A") ) {
                            grid[i][j].setText("4");
                            //block[i][j].setInput_value(4);
                            if((j<=2 &(i<3 | i>5)) | ( (i>=3 & i<=5) &(j>=3 & j<=5) ) | (j>5 &(i<3 | i>5)))
                                grid[i][j].setBackgroundColor(Color.parseColor("#BCC6CC"));
                            else
                                grid[i][j].setBackgroundColor(Color.parseColor("#FFFFFF"));
                            grid[i][j].setTextColor(Color.BLACK);
                            matrix[i][j].setInput_Value(4);



                        }
                    }
                }
                for (int k =0; k<10; k++) {
                    choice [k].setEnabled(false);
                    choice [k].setVisibility(View.INVISIBLE);
                }

            }
        });
        choice[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i =0; i<9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if( grid[i][j].getCurrentTextColor() == Color.parseColor("#17202A") ) {
                            grid[i][j].setText("5");
                            //block[i][j].setInput_value(5);
                            if((j<=2 &(i<3 | i>5)) | ( (i>=3 & i<=5) &(j>=3 & j<=5) ) | (j>5 &(i<3 | i>5)))
                                grid[i][j].setBackgroundColor(Color.parseColor("#BCC6CC"));
                            else
                                grid[i][j].setBackgroundColor(Color.parseColor("#FFFFFF"));
                            grid[i][j].setTextColor(Color.BLACK);
                            matrix[i][j].setInput_Value(5);



                        }
                    }
                }
                for (int k =0; k<10; k++) {
                    choice [k].setEnabled(false);
                    choice [k].setVisibility(View.INVISIBLE);
                }

            }
        });
        choice[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i =0; i<9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if( grid[i][j].getCurrentTextColor() == Color.parseColor("#17202A") ) {
                            grid[i][j].setText("6");
                            //block[i][j].setInput_value(6);
                            if((j<=2 &(i<3 | i>5)) | ( (i>=3 & i<=5) &(j>=3 & j<=5) ) | (j>5 &(i<3 | i>5)))
                                grid[i][j].setBackgroundColor(Color.parseColor("#BCC6CC"));
                            else
                                grid[i][j].setBackgroundColor(Color.parseColor("#FFFFFF"));
                            grid[i][j].setTextColor(Color.BLACK);
                            matrix[i][j].setInput_Value(6);



                        }
                    }
                }
                for (int k =0; k<10; k++) {
                    choice [k].setEnabled(false);
                    choice [k].setVisibility(View.INVISIBLE);
                }

            }
        });
        choice[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i =0; i<9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if( grid[i][j].getCurrentTextColor() == Color.parseColor("#17202A") ) {
                            grid[i][j].setText("7");
                            //block[i][j].setInput_value(7);
                            if((j<=2 &(i<3 | i>5)) | ( (i>=3 & i<=5) &(j>=3 & j<=5) ) | (j>5 &(i<3 | i>5)))
                                grid[i][j].setBackgroundColor(Color.parseColor("#BCC6CC"));
                            else
                                grid[i][j].setBackgroundColor(Color.parseColor("#FFFFFF"));
                            grid[i][j].setTextColor(Color.BLACK);
                            matrix[i][j].setInput_Value(7);



                        }
                    }
                }
                for (int k =0; k<10; k++) {
                    choice [k].setEnabled(false);
                    choice [k].setVisibility(View.INVISIBLE);
                }

            }
        });
        choice[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i =0; i<9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if( grid[i][j].getCurrentTextColor() == Color.parseColor("#17202A") ) {
                            grid[i][j].setText("8");
                            //block[i][j].setInput_value(8);
                            if((j<=2 &(i<3 | i>5)) | ( (i>=3 & i<=5) &(j>=3 & j<=5) ) | (j>5 &(i<3 | i>5)))
                                grid[i][j].setBackgroundColor(Color.parseColor("#BCC6CC"));
                            else
                                grid[i][j].setBackgroundColor(Color.parseColor("#FFFFFF"));
                            grid[i][j].setTextColor(Color.BLACK);
                            matrix[i][j].setInput_Value(8);



                        }
                    }
                }
                for (int k =0; k<10; k++) {
                    choice [k].setEnabled(false);
                    choice [k].setVisibility(View.INVISIBLE);
                }

            }
        });
        choice[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i =0; i<9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if( grid[i][j].getCurrentTextColor() == Color.parseColor("#17202A") ) {
                            grid[i][j].setText("9");
                            //block[i][j].setInput_value(9);
                            if((j<=2 &(i<3 | i>5)) | ( (i>=3 & i<=5) &(j>=3 & j<=5) ) | (j>5 &(i<3 | i>5)))
                                grid[i][j].setBackgroundColor(Color.parseColor("#BCC6CC"));
                            else
                                grid[i][j].setBackgroundColor(Color.parseColor("#FFFFFF"));
                            grid[i][j].setTextColor(Color.BLACK);
                            matrix[i][j].setInput_Value(9);



                        }
                    }
                }
                for (int k =0; k<10; k++) {
                    choice [k].setEnabled(false);
                    choice [k].setVisibility(View.INVISIBLE);
                }

            }
        });

        solve.setEnabled(false);
        solve.setVisibility(View.INVISIBLE);

        reset.setEnabled(false);
        reset.setVisibility(View.INVISIBLE);

        go2camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Camera_Activity_UI.class));
            }
        });


        lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i =0; i<9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if(matrix[i][j].getInput_value()==3) {
                            Log.d("sudokusolver", "\ncell " + i + j + " is ready");
                            /*Log.d("sudokusolver", "\ncell " + i + j + " options:");
                            matrix[i][j].printAllOptions();
                            matrix[i][j].removeOption(5);
                            matrix[i][j].printAllOptions();*/
                        }

                        if( grid[i][j].getCurrentTextColor() == Color.parseColor("#17202A") ) {
                            if((j<=2 &(i<3 | i>5)) | ( (i>=3 & i<=5) &(j>=3 & j<=5) ) | (j>5 &(i<3 | i>5)))
                                grid[i][j].setBackgroundColor(Color.parseColor("#BCC6CC"));
                            else
                                grid[i][j].setBackgroundColor(Color.parseColor("#FFFFFF"));
                        }
                        grid[i][j].setTextColor(Color.BLACK);
                        grid[i][j].setEnabled(false);
                    }
                    choice[i].setEnabled(false);
                    choice[i].setVisibility(View.INVISIBLE);
                }
                choice[9].setEnabled(false);
                choice[9].setVisibility(View.INVISIBLE);
                lock.setEnabled(false);
                lock.setVisibility(View.INVISIBLE);

                solve.setEnabled(true);
                solve.setVisibility(View.VISIBLE);

                reset.setEnabled(true);
                reset.setVisibility(View.VISIBLE);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0; i<9; i++){
                    for(int j=0; j<9; j++){
                        grid[i][j].setText(" ");
                        matrix[i][j].eraseInput_Value();
                        grid[i][j].setEnabled(true);
                    }
                    choice[i].setEnabled(false);
                    choice[i].setVisibility(View.INVISIBLE);
                }
                choice[9].setEnabled(false);
                choice[9].setVisibility(View.INVISIBLE);

                lock.setEnabled(true);
                lock.setVisibility(View.VISIBLE);

                solve.setEnabled(false);
                solve.setVisibility(View.INVISIBLE);

                reset.setEnabled(false);
                reset.setVisibility(View.INVISIBLE);
            }
        });

        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean done=false;
                int tryAgains = 0;
                while(tryAgains<3) {
                    sizes = updateSizes(matrix, sizes);

                    matrix = removeAllRowOptions(matrix);
                    matrix = removeAllColOptions(matrix);
                    matrix = removeAllBlockOptions(matrix);
                    matrix = confirmAllSingleOptions(matrix);

                    done = equalTo(matrix, sizes);
                    if(done)
                        tryAgains++;
                    else
                        tryAgains=0;
                }
                /*if(done)
                    Log.d("sudokusolver", "matrix and sizes match");
                else
                    Log.d("sudokusolver", "matrix and sizes DO NOT match");*/
                printAll(matrix);

                for(int i=0; i<9; i++){
                    for(int j=0; j<9; j++){
                        if(matrix[i][j].getInput_value() ==1)
                            grid[i][j].setText("1");
                        else if(matrix[i][j].getInput_value() ==2)
                            grid[i][j].setText("2");
                        else if(matrix[i][j].getInput_value() ==3)
                            grid[i][j].setText("3");
                        else if(matrix[i][j].getInput_value() ==4)
                            grid[i][j].setText("4");
                        else if(matrix[i][j].getInput_value() ==5)
                            grid[i][j].setText("5");
                        else if(matrix[i][j].getInput_value() ==6)
                            grid[i][j].setText("6");
                        else if(matrix[i][j].getInput_value() ==7)
                            grid[i][j].setText("7");
                        else if(matrix[i][j].getInput_value() ==8)
                            grid[i][j].setText("8");
                        else if(matrix[i][j].getInput_value() ==9)
                            grid[i][j].setText("9");
                        else if(matrix[i][j].getInput_value() ==0)
                            grid[i][j].setText(" ");
                    }
                }

            }
        });


    }

    public void setMatrixValues(int row, int col, int value){
        matrix[row][col].setInput_Value(value);
    }

    public void setGridValues(int row, int col, int value){
        grid[row][col].setText(Integer.toString(value));
    }



    public int [][] updateSizes(cell[][]matrix, int[][]sizes){
        for(int i =0; i<9; i++){
            for (int j = 0; j<9; j++){
                sizes[i][j] = matrix[i][j].getSize();
            }
        }
        return(sizes);
    }

    public boolean equalTo(cell[][] matrix, int [][]sizes){
        boolean result = true;
        for(int i =0; i<9; i++){
            for (int j = 0; j<9; j++){
                if( matrix[i][j].getSize() != sizes[i][j] ){
                    result = false;
                }
            }
        }
        return(result);
    }

    public cell[] [] confirmAllSingleOptions(cell [][] matrix){
        for(int i =0; i<9; i++){
            for(int j=0; j<9; j++){
                if(matrix[i][j].getSize()==1){
                    matrix[i][j].completeSingle();
                    Log.d("sudokusolver", "cell "+i+j+" confirmSingleOptions: "+matrix[i][j].getInput_value());
                }
            }
        }
        return(matrix);
    }

    public cell[][] removeAllBlockOptions(cell[][]matrix){
        matrix = removeBlockTL(matrix);
        matrix = removeBlockTM(matrix);
        matrix = removeBlockTR(matrix);

        matrix = removeBlockML(matrix);
        matrix = removeBlockMM(matrix);
        matrix = removeBlockMR(matrix);

        matrix = removeBlockBL(matrix);
        matrix = removeBlockBM(matrix);
        matrix = removeBlockBR(matrix);

        return (matrix);
    }

    public cell[][] removeBlockTL(cell[][] matrix){
        for (int k = 0; k<3; k++) {
            for (int i=0; i<3; i++) {
                if (matrix[k][i].getInput_value() != 0) {
                    for (int j = 0; j < 3; j++) {
                        for(int z =0; z<3; z++) {
                            matrix[j][z].removeOption(matrix[k][i].getInput_value());
                            //Log.d("sudokusolver", "cell 0"+k);
                            //matrixRow[k].printAllOptions();
                        }
                    }

                }
            }
        }
        return(matrix);
    }

    public cell[][] removeBlockTM(cell[][] matrix){
        for (int k = 0; k<3; k++) {
            for (int i=3; i<6; i++) {
                if (matrix[k][i].getInput_value() != 0) {
                    for (int j = 0; j < 3; j++) {
                        for(int z =3; z<6; z++) {
                            matrix[j][z].removeOption(matrix[k][i].getInput_value());
                            //Log.d("sudokusolver", "cell 0"+k);
                            //matrixRow[k].printAllOptions();
                        }
                    }

                }
            }
        }
        return(matrix);
    }

    public cell[][] removeBlockTR(cell[][] matrix){
        for (int k = 0; k<3; k++) {
            for (int i=6; i<9; i++) {
                if (matrix[k][i].getInput_value() != 0) {
                    for (int j = 0; j < 3; j++) {
                        for(int z =6; z<9; z++) {
                            matrix[j][z].removeOption(matrix[k][i].getInput_value());
                            //Log.d("sudokusolver", "cell 0"+k);
                            //matrixRow[k].printAllOptions();
                        }
                    }

                }
            }
        }
        return(matrix);
    }

    public cell[][] removeBlockML(cell[][] matrix){
        for (int k = 3; k<6; k++) {
            for (int i=0; i<3; i++) {
                if (matrix[k][i].getInput_value() != 0) {
                    for (int j = 3; j < 6; j++) {
                        for(int z =0; z<3; z++) {
                            matrix[j][z].removeOption(matrix[k][i].getInput_value());
                            //Log.d("sudokusolver", "cell 0"+k);
                            //matrixRow[k].printAllOptions();
                        }
                    }

                }
            }
        }
        return(matrix);
    }

    public cell[][] removeBlockMM(cell[][] matrix){
        for (int k = 3; k<6; k++) {
            for (int i=3; i<6; i++) {
                if (matrix[k][i].getInput_value() != 0) {
                    for (int j = 3; j < 6; j++) {
                        for(int z =3; z<6; z++) {
                            matrix[j][z].removeOption(matrix[k][i].getInput_value());
                            //Log.d("sudokusolver", "cell 0"+k);
                            //matrixRow[k].printAllOptions();
                        }
                    }

                }
            }
        }
        return(matrix);
    }

    public cell[][] removeBlockMR(cell[][] matrix){
        for (int k = 3; k<6; k++) {
            for (int i=6; i<9; i++) {
                if (matrix[k][i].getInput_value() != 0) {
                    for (int j = 3; j < 6; j++) {
                        for(int z =6; z<9; z++) {
                            matrix[j][z].removeOption(matrix[k][i].getInput_value());
                            //Log.d("sudokusolver", "cell 0"+k);
                            //matrixRow[k].printAllOptions();
                        }
                    }

                }
            }
        }
        return(matrix);
    }

    public cell[][] removeBlockBL(cell[][] matrix){
        for (int k = 6; k<9; k++) {
            for (int i=0; i<3; i++) {
                if (matrix[k][i].getInput_value() != 0) {
                    for (int j = 6; j < 9; j++) {
                        for(int z =0; z<3; z++) {
                            matrix[j][z].removeOption(matrix[k][i].getInput_value());
                            //Log.d("sudokusolver", "cell 0"+k);
                            //matrixRow[k].printAllOptions();
                        }
                    }

                }
            }
        }
        return(matrix);
    }

    public cell[][] removeBlockBM(cell[][] matrix){
        for (int k = 6; k<9; k++) {
            for (int i=3; i<6; i++) {
                if (matrix[k][i].getInput_value() != 0) {
                    for (int j = 6; j < 9; j++) {
                        for(int z =3; z<6; z++) {
                            matrix[j][z].removeOption(matrix[k][i].getInput_value());
                            //Log.d("sudokusolver", "cell 0"+k);
                            //matrixRow[k].printAllOptions();
                        }
                    }

                }
            }
        }
        return(matrix);
    }

    public cell[][] removeBlockBR(cell[][] matrix){
        for (int k = 6; k<9; k++) {
            for (int i=6; i<9; i++) {
                if (matrix[k][i].getInput_value() != 0) {
                    for (int j = 6; j < 9; j++) {
                        for(int z =6; z<9; z++) {
                            matrix[j][z].removeOption(matrix[k][i].getInput_value());
                            //Log.d("sudokusolver", "cell 0"+k);
                            //matrixRow[k].printAllOptions();
                        }
                    }

                }
            }
        }
        return(matrix);
    }

    public cell[][] removeAllRowOptions(cell[][] matrix){
        matrix[0]=removeRowOptions(matrix[0], 0);
        matrix[1]=removeRowOptions(matrix[1], 1);
        matrix[2]=removeRowOptions(matrix[2], 2);
        matrix[3]=removeRowOptions(matrix[3], 3);
        matrix[4]=removeRowOptions(matrix[4], 4);
        matrix[5]=removeRowOptions(matrix[5], 5);
        matrix[6]=removeRowOptions(matrix[6], 6);
        matrix[7]=removeRowOptions(matrix[7], 7);
        matrix[8]=removeRowOptions(matrix[8], 8);

        return(matrix);
    }

    public cell[][] removeAllColOptions(cell[][] matrix){
        matrix=removeColOptions(matrix, 0);
        matrix=removeColOptions(matrix, 1);
        matrix=removeColOptions(matrix, 2);
        matrix=removeColOptions(matrix, 3);
        matrix=removeColOptions(matrix, 4);
        matrix=removeColOptions(matrix, 5);
        matrix=removeColOptions(matrix, 6);
        matrix=removeColOptions(matrix, 7);
        matrix=removeColOptions(matrix, 8);

        return(matrix);
    }

    public cell[][] removeColOptions(cell[][] matrix, int col){
        for (int k = 0; k<9; k++) {
            if (matrix[k][col].getInput_value() != 0) {
                for (int j = 0; j < 9; j++) {
                    matrix[j][col].removeOption(matrix[k][col].getInput_value());
                    //Log.d("sudokusolver", "cell 0"+k);
                    //matrixRow[k].printAllOptions();
                }

            }
        }
        return(matrix);
    }

    public void printAll(cell [][] matrix){
        printRow(matrix[0], 0);
        printRow(matrix[1], 1);
        printRow(matrix[2], 2);
        printRow(matrix[3], 3);
        printRow(matrix[4], 4);
        printRow(matrix[5], 5);
        printRow(matrix[6], 6);
        printRow(matrix[7], 7);
        printRow(matrix[8], 8);
        Log.d("sudokusolver", "done");
    }

    public cell[] removeRowOptions(cell[] matrixRow, int row){

        for (int k = 0; k<9; k++) {
            if (matrixRow[k].getInput_value() != 0) {
                for (int j = 0; j < 9; j++) {
                    matrixRow[j].removeOption(matrixRow[k].getInput_value());
                    //Log.d("sudokusolver", "row + cell "+row+k);
                    //matrixRow[k].printAllOptions();
                }
            }
        }
        return(matrixRow);


    }
    public void printRow(cell[] matrixRow, int row){
        Log.d("sudokusolver", "Row "+row);
        for(int i = 0; i<9; i++){
            Log.d("sudokusolver", "cell "+i);
            matrixRow[i].printAllOptions();
        }

    }
}
