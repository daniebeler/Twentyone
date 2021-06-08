package com.daniebeler.Twentyone;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd1, btnAdd2, btnAdd3, btnAdd4, btnAdd5, btnAdd6, btnPlay, btnHelp, btnHome, btnAgainstAIEasy, btnAgainstAIHard;
    TextView tvCounter, tvCounter2, tvHelp;
    ImageView iv00;
    Typeface tf1;

    boolean bPlayerOne = false, bHelp = false, bCanClick = true;
    int iCounter = 0, iActivity = 0;    //0 = Home
                                        //1 = 1 vs 1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv00 = findViewById(R.id.idimage00);
        btnAdd1 = findViewById(R.id.idAdd1);
        btnAdd2 = findViewById(R.id.idAdd2);
        btnAdd3 = findViewById(R.id.idAdd3);
        btnAdd4 = findViewById(R.id.idAdd4);
        btnAdd5 = findViewById(R.id.idAdd5);
        btnAdd6 = findViewById(R.id.idAdd6);
        btnPlay = findViewById(R.id.idPlay);
        btnHelp = findViewById(R.id.idHelp);
        btnHome = findViewById(R.id.idHome);
        btnAgainstAIEasy = findViewById(R.id.idAI0);
        btnAgainstAIHard = findViewById(R.id.idAI1);
        tvCounter = findViewById(R.id.idCounter);
        tvCounter2 = findViewById(R.id.idCounter2);
        tvHelp = findViewById(R.id.idHelptv);

        tf1 = Typeface.createFromAsset(getAssets(), "fonts/concertone-regular.ttf");

        btnAdd1.setOnClickListener(this);
        btnAdd2.setOnClickListener(this);
        btnAdd3.setOnClickListener(this);
        btnAdd4.setOnClickListener(this);
        btnAdd5.setOnClickListener(this);
        btnAdd6.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        btnHelp.setOnClickListener(this);
        btnHome.setOnClickListener(this);
        btnAgainstAIEasy.setOnClickListener(this);
        btnAgainstAIHard.setOnClickListener(this);

        btnAdd1.setTypeface(tf1);
        btnAdd2.setTypeface(tf1);
        btnAdd3.setTypeface(tf1);
        btnAdd4.setTypeface(tf1);
        btnAdd5.setTypeface(tf1);
        btnAdd6.setTypeface(tf1);
        btnPlay.setTypeface(tf1);
        btnHelp.setTypeface(tf1);
        btnAgainstAIEasy.setTypeface(tf1);
        btnAgainstAIHard.setTypeface(tf1);
        tvCounter.setTypeface(tf1);
        tvCounter2.setTypeface(tf1);
        tvHelp.setTypeface(tf1);
        btnHome.setTypeface(tf1);

        btnAdd1.setVisibility(View.INVISIBLE);
        btnAdd2.setVisibility(View.INVISIBLE);
        btnAdd3.setVisibility(View.INVISIBLE);
        btnAdd4.setVisibility(View.INVISIBLE);
        btnAdd5.setVisibility(View.INVISIBLE);
        btnAdd6.setVisibility(View.INVISIBLE);
        tvHelp.setVisibility(View.INVISIBLE);
        tvCounter.setVisibility(View.INVISIBLE);
        tvCounter2.setVisibility(View.INVISIBLE);
        btnHome.setVisibility(View.INVISIBLE);

    }
    @Override
    protected void onResume() {
        super.onResume();
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.idAdd1:
            case R.id.idAdd4:
                Clicked(1);
                break;
            case R.id.idAdd2:
            case R.id.idAdd5:
                Clicked(2);
                break;
            case R.id.idAdd3:
            case R.id.idAdd6:
                Clicked(3);
                break;
            case R.id.idPlay:
                FadeOutMenu(0);
                break;
            case R.id.idAI0:
                FadeOutMenu(1);
                break;
            case R.id.idAI1:    //Hard
                FadeOutMenu(2);
                break;
            case R.id.idHome:
               FadeInMenu();
                break;
            case R.id.idHelp:
                Help();
                break;
        }
    }

    public void Clicked(int i) {
        if (bCanClick) {
            bCanClick = false;
            if (iActivity == 0) {
                iCounter = iCounter + i;

                if (i == 1) {
                    tvCounter.setText(String.valueOf(iCounter));
                    tvCounter2.setText(String.valueOf(iCounter));
                } else if (i == 2) {
                    tvCounter.setText(String.valueOf(iCounter - 1));
                    tvCounter2.setText(String.valueOf(iCounter - 1));
                    Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        public void run() {
                            tvCounter.setText(String.valueOf(iCounter));
                            tvCounter2.setText(String.valueOf(iCounter));
                        }
                    }, 150);
                } else {
                    tvCounter.setText(String.valueOf(iCounter - 2));
                    tvCounter2.setText(String.valueOf(iCounter - 2));
                    Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        public void run() {
                            tvCounter.setText(String.valueOf(iCounter - 1));
                            tvCounter2.setText(String.valueOf(iCounter - 1));
                        }
                    }, 150);
                    Handler handler2 = new Handler();
                    handler2.postDelayed(new Runnable() {
                        public void run() {
                            tvCounter.setText(String.valueOf(iCounter));
                            tvCounter2.setText(String.valueOf(iCounter));
                        }
                    }, 300);
                }

                if (iCounter < 19) {
                    if (bPlayerOne) {
                        ChangeButtons(1);
                        btnAdd4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd5.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd6.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd1.setVisibility(View.VISIBLE);
                        btnAdd2.setVisibility(View.VISIBLE);
                        btnAdd3.setVisibility(View.VISIBLE);

                        Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            public void run() {
                                btnAdd4.setVisibility(View.INVISIBLE);
                                btnAdd5.setVisibility(View.INVISIBLE);
                                btnAdd6.setVisibility(View.INVISIBLE);
                            }
                        }, 300);

                    } else {
                        ChangeButtons(0);
                        btnAdd1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd5.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd6.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd4.setVisibility(View.VISIBLE);
                        btnAdd5.setVisibility(View.VISIBLE);
                        btnAdd6.setVisibility(View.VISIBLE);
                        Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            public void run() {
                                btnAdd1.setVisibility(View.INVISIBLE);
                                btnAdd2.setVisibility(View.INVISIBLE);
                                btnAdd3.setVisibility(View.INVISIBLE);
                            }
                        }, 300);
                    }
                } else if (iCounter == 19) {
                    if (bPlayerOne) {
                        ChangeButtons(1);
                        btnAdd4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd5.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd6.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd1.setVisibility(View.VISIBLE);
                        btnAdd2.setVisibility(View.VISIBLE);
                        Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            public void run() {
                                btnAdd4.setVisibility(View.INVISIBLE);
                                btnAdd5.setVisibility(View.INVISIBLE);
                                btnAdd6.setVisibility(View.INVISIBLE);
                            }
                        }, 300);

                    } else {
                        ChangeButtons(0);
                        btnAdd1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd5.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd4.setVisibility(View.VISIBLE);
                        btnAdd5.setVisibility(View.VISIBLE);
                        Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            public void run() {
                                btnAdd1.setVisibility(View.INVISIBLE);
                                btnAdd2.setVisibility(View.INVISIBLE);
                                btnAdd3.setVisibility(View.INVISIBLE);
                            }
                        }, 300);
                    }
                } else if (iCounter == 20) {
                    if (bPlayerOne) {
                        ChangeButtons(1);
                        btnAdd4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd5.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd6.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd1.setVisibility(View.VISIBLE);
                        Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            public void run() {
                                btnAdd4.setVisibility(View.INVISIBLE);
                                btnAdd5.setVisibility(View.INVISIBLE);
                                btnAdd6.setVisibility(View.INVISIBLE);
                            }
                        }, 300);

                    } else {
                        ChangeButtons(0);
                        btnAdd1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd4.setVisibility(View.VISIBLE);
                        Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            public void run() {
                                btnAdd1.setVisibility(View.INVISIBLE);
                                btnAdd2.setVisibility(View.INVISIBLE);
                                btnAdd3.setVisibility(View.INVISIBLE);
                            }
                        }, 300);
                    }
                } else {      //21
                    if (btnAdd1.getVisibility() == View.VISIBLE) {
                        btnAdd1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                    } else if (btnAdd2.getVisibility() == View.VISIBLE) {
                        btnAdd2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                    } else if (btnAdd3.getVisibility() == View.VISIBLE) {
                        btnAdd3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                    } else if (btnAdd4.getVisibility() == View.VISIBLE) {
                        btnAdd4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                    } else if (btnAdd5.getVisibility() == View.VISIBLE) {
                        btnAdd5.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                    } else if (btnAdd6.getVisibility() == View.VISIBLE) {
                        btnAdd6.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                    }
                    Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        public void run() {
                            btnAdd1.setVisibility(View.INVISIBLE);
                            btnAdd2.setVisibility(View.INVISIBLE);
                            btnAdd3.setVisibility(View.INVISIBLE);
                            btnAdd4.setVisibility(View.INVISIBLE);
                            btnAdd5.setVisibility(View.INVISIBLE);
                            btnAdd6.setVisibility(View.INVISIBLE);
                        }
                    }, 300);

                    if (bPlayerOne) {
                        tvCounter.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        Handler handler2 = new Handler();
                        handler2.postDelayed(new Runnable() {
                            public void run() {
                                    tvCounter.setText(R.string.winner);
                                    tvCounter.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                            }
                        }, 300);
                    } else {
                        tvCounter2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        Handler handler2 = new Handler();
                        handler2.postDelayed(new Runnable() {
                            public void run() {
                                tvCounter2.setText(R.string.winner);
                                tvCounter2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                            }
                        }, 300);
                    }

                    btnHome.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                    btnHome.setVisibility(View.VISIBLE);

                }

                bPlayerOne = !bPlayerOne;
                Handler handler12 = new Handler();
                handler12.postDelayed(new Runnable() {
                    public void run() {
                        bCanClick = true;
                    }
                }, 600);
            }

            else if (iActivity == 1 || iActivity == 2) {
                iCounter = iCounter + i;

                if (i == 1) {
                    tvCounter.setText(String.valueOf(iCounter));
                } else if (i == 2) {
                    tvCounter.setText(String.valueOf(iCounter - 1));
                    Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        public void run() {
                            tvCounter.setText(String.valueOf(iCounter));
                        }
                    }, 150);
                } else {
                    tvCounter.setText(String.valueOf(iCounter - 2));
                    Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        public void run() {
                            tvCounter.setText(String.valueOf(iCounter - 1));
                        }
                    }, 150);
                    Handler handler2 = new Handler();
                    handler2.postDelayed(new Runnable() {
                        public void run() {
                            tvCounter.setText(String.valueOf(iCounter));
                        }
                    }, 300);
                }

                if (iCounter < 19) {
                    if (bPlayerOne) {
                        ChangeButtons(1);
                        btnAdd4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd5.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd6.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd1.setVisibility(View.VISIBLE);
                        btnAdd2.setVisibility(View.VISIBLE);
                        btnAdd3.setVisibility(View.VISIBLE);

                        Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            public void run() {
                                btnAdd4.setVisibility(View.INVISIBLE);
                                btnAdd5.setVisibility(View.INVISIBLE);
                                btnAdd6.setVisibility(View.INVISIBLE);
                            }
                        }, 300);

                    } else {
                        ChangeButtons(0);
                        btnAdd1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd5.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd6.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd4.setVisibility(View.VISIBLE);
                        btnAdd5.setVisibility(View.VISIBLE);
                        btnAdd6.setVisibility(View.VISIBLE);
                        Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            public void run() {
                                btnAdd1.setVisibility(View.INVISIBLE);
                                btnAdd2.setVisibility(View.INVISIBLE);
                                btnAdd3.setVisibility(View.INVISIBLE);
                            }
                        }, 300);
                    }
                } else if (iCounter == 19) {
                    if (bPlayerOne) {
                        ChangeButtons(1);
                        btnAdd4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd5.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd6.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd1.setVisibility(View.VISIBLE);
                        btnAdd2.setVisibility(View.VISIBLE);
                        Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            public void run() {
                                btnAdd4.setVisibility(View.INVISIBLE);
                                btnAdd5.setVisibility(View.INVISIBLE);
                                btnAdd6.setVisibility(View.INVISIBLE);
                            }
                        }, 300);

                    } else {
                        ChangeButtons(0);
                        btnAdd1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd5.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd4.setVisibility(View.VISIBLE);
                        btnAdd5.setVisibility(View.VISIBLE);
                        Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            public void run() {
                                btnAdd1.setVisibility(View.INVISIBLE);
                                btnAdd2.setVisibility(View.INVISIBLE);
                                btnAdd3.setVisibility(View.INVISIBLE);
                            }
                        }, 300);
                    }
                } else if (iCounter == 20) {
                    if (bPlayerOne) {
                        ChangeButtons(1);
                        btnAdd4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd5.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd6.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd1.setVisibility(View.VISIBLE);
                        Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            public void run() {
                                btnAdd4.setVisibility(View.INVISIBLE);
                                btnAdd5.setVisibility(View.INVISIBLE);
                                btnAdd6.setVisibility(View.INVISIBLE);
                            }
                        }, 300);

                    } else {
                        ChangeButtons(0);
                        btnAdd1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                        btnAdd4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        btnAdd4.setVisibility(View.VISIBLE);
                        Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            public void run() {
                                btnAdd1.setVisibility(View.INVISIBLE);
                                btnAdd2.setVisibility(View.INVISIBLE);
                                btnAdd3.setVisibility(View.INVISIBLE);
                            }
                        }, 300);
                    }
                } else {      //21
                    if (btnAdd1.getVisibility() == View.VISIBLE) {
                        btnAdd1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                    } else if (btnAdd2.getVisibility() == View.VISIBLE) {
                        btnAdd2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                    } else if (btnAdd3.getVisibility() == View.VISIBLE) {
                        btnAdd3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                    } else if (btnAdd4.getVisibility() == View.VISIBLE) {
                        btnAdd4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                    } else if (btnAdd5.getVisibility() == View.VISIBLE) {
                        btnAdd5.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                    } else if (btnAdd6.getVisibility() == View.VISIBLE) {
                        btnAdd6.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                    }
                    Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        public void run() {
                            btnAdd1.setVisibility(View.INVISIBLE);
                            btnAdd2.setVisibility(View.INVISIBLE);
                            btnAdd3.setVisibility(View.INVISIBLE);
                            btnAdd4.setVisibility(View.INVISIBLE);
                            btnAdd5.setVisibility(View.INVISIBLE);
                            btnAdd6.setVisibility(View.INVISIBLE);
                        }
                    }, 300);

                    tvCounter.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
                    Handler handler2 = new Handler();
                    handler2.postDelayed(new Runnable() {
                        public void run() {
                            if (!bPlayerOne) {
                                tvCounter.setText(R.string.winner);
                            } else {
                                tvCounter.setText(R.string.looser);
                            }
                            tvCounter.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        }
                    }, 300);

                    btnHome.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                    btnHome.setVisibility(View.VISIBLE);
                }

                bPlayerOne = !bPlayerOne;
                Handler handler13 = new Handler();
                handler13.postDelayed(new Runnable() {
                    public void run() {
                        bCanClick = true;
                        if (bPlayerOne && iCounter < 21) {
                            if (iActivity == 1){
                                AI(0);
                            }else{
                                AI(1);
                            }
                        }
                    }
                }, 600);
            }
        }
    }

    public void FadeInMenu () {
        if (bCanClick) {
            bCanClick = false;
            iv00.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_right_down));
            iv00.setVisibility(View.VISIBLE);
            btnHome.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
            tvCounter.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
            if (tvCounter2.getVisibility() == View.VISIBLE) {
                tvCounter2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
            }


            Handler handler3 = new Handler();
            handler3.postDelayed(new Runnable() {
                public void run() {
                    btnHelp.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                    btnHelp.setVisibility(View.VISIBLE);
                }
            }, 1000);
            Handler handler4 = new Handler();
            handler4.postDelayed(new Runnable() {
                public void run() {
                    btnHome.setVisibility(View.INVISIBLE);
                    tvCounter.setVisibility(View.INVISIBLE);
                    tvCounter2.setVisibility(View.INVISIBLE);
                    btnPlay.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                    btnAgainstAIEasy.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                    btnAgainstAIHard.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                    btnPlay.setVisibility(View.VISIBLE);
                    btnAgainstAIEasy.setVisibility(View.VISIBLE);
                    btnAgainstAIHard.setVisibility(View.VISIBLE);
                }
            }, 300);

            Handler handler12 = new Handler();
            handler12.postDelayed(new Runnable() {
                public void run() {
                    bCanClick = true;
                }
            }, 600);
        }
    }
    public void FadeOutMenu (int i){
        if (bCanClick) {
            bCanClick = false;
        iCounter = 0;
            tvCounter.setText(String.valueOf(iCounter));
            tvCounter2.setText(String.valueOf(iCounter));
        ChangeButtons(0);
        ChangeButtons(1);
        iv00.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_left_up));
                btnHelp.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_out));
                btnPlay.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_out));
                btnAgainstAIEasy.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_out));
                btnAgainstAIHard.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_out));

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        btnHelp.setVisibility(View.INVISIBLE);
                        btnPlay.setVisibility(View.INVISIBLE);
                        btnAgainstAIEasy.setVisibility(View.INVISIBLE);
                        btnAgainstAIHard.setVisibility(View.INVISIBLE);
                        Random r = new Random();
                        if (r.nextInt(2) == 1){
                            btnAdd1.setVisibility(View.VISIBLE);
                            btnAdd2.setVisibility(View.VISIBLE);
                            btnAdd3.setVisibility(View.VISIBLE);
                            btnAdd1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                            btnAdd2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                            btnAdd3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                            bPlayerOne = false;
                            iv00.setVisibility(View.INVISIBLE);
                        }else{
                            btnAdd4.setVisibility(View.VISIBLE);
                            btnAdd5.setVisibility(View.VISIBLE);
                            btnAdd6.setVisibility(View.VISIBLE);
                            btnAdd4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                            btnAdd5.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                            btnAdd6.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                            bPlayerOne = true;
                            iv00.setVisibility(View.INVISIBLE);
                        }
            }
        }, 300);

        switch (i) {
            case 0:     // 1 vs 1
                btnAdd4.setBackgroundResource(R.drawable.button00);
                btnAdd5.setBackgroundResource(R.drawable.button00);
                btnAdd6.setBackgroundResource(R.drawable.button00);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    public void run() {
                        iActivity = 0;
                        tvCounter.setVisibility(View.VISIBLE);
                        tvCounter2.setVisibility(View.VISIBLE);
                        tvCounter.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        tvCounter2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                    }
                }, 300);
                break;
            case 1:     //Easy

                btnAdd4.setBackgroundResource(R.drawable.button04);
                btnAdd5.setBackgroundResource(R.drawable.button04);
                btnAdd6.setBackgroundResource(R.drawable.button04);
                Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    public void run() {
                        iActivity = 1;
                        tvCounter.setVisibility(View.VISIBLE);
                        tvCounter.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        if (bPlayerOne){
                            AI(0);
                        }
                    }
                }, 600);
                break;
            case 2:     //Hard
                btnAdd4.setBackgroundResource(R.drawable.button04);
                btnAdd5.setBackgroundResource(R.drawable.button04);
                btnAdd6.setBackgroundResource(R.drawable.button04);
                Handler handler3 = new Handler();
                handler3.postDelayed(new Runnable() {
                    public void run() {
                        iActivity = 2;
                        tvCounter.setVisibility(View.VISIBLE);
                        tvCounter.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                        if (bPlayerOne){
                            AI(1);
                        }
                    }
                }, 600);
                break;
        }

        Handler handler12 = new Handler();
        handler12.postDelayed(new Runnable() {
            public void run() {
                bCanClick = true;
            }
        }, 600);
    }
}

    public void Help (){
        if (bHelp && bCanClick){
            bCanClick = false;
            bHelp = false;
            tvHelp.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
            btnHelp.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
            Handler handler4 = new Handler();
            handler4.postDelayed(new Runnable() {
                public void run() {
                    tvHelp.setVisibility(View.INVISIBLE);
                    btnHelp.setText(R.string.howtoplay);
                    btnHelp.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                    btnPlay.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                    btnAgainstAIEasy.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                    btnAgainstAIHard.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                    btnPlay.setVisibility(View.VISIBLE);
                    btnAgainstAIEasy.setVisibility(View.VISIBLE);
                    btnAgainstAIHard.setVisibility(View.VISIBLE);
                }
            }, 300);
            Handler handler5 = new Handler();
            handler5.postDelayed(new Runnable() {
                public void run() {
                    bCanClick = true;
                }
            }, 600);
        }else if (!bHelp && bCanClick){
            bCanClick = false;
            bHelp = true;
            btnPlay.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
            btnAgainstAIEasy.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
            btnAgainstAIHard.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
            btnHelp.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_out));
            Handler handler5 = new Handler();
            handler5.postDelayed(new Runnable() {
                public void run() {
                    btnPlay.setVisibility(View.INVISIBLE);
                    btnAgainstAIEasy.setVisibility(View.INVISIBLE);
                    btnAgainstAIHard.setVisibility(View.INVISIBLE);
                    btnHelp.setText(R.string.back);
                    btnHelp.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                    tvHelp.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in));
                    tvHelp.setVisibility(View.VISIBLE);
                }
            }, 300);
            Handler handler6 = new Handler();
            handler6.postDelayed(new Runnable() {
                public void run() {
                    bCanClick = true;
                }
            }, 600);
        }
    }

    public void AI (final int i){
        Handler handler6 = new Handler();
        handler6.postDelayed(new Runnable() {
            public void run() {
                int iButton = 0;
        if (i == 0){

            if(iCounter < 19){
                Random r = new Random();
                switch (r.nextInt(4 - 1) + 1){
                    case 1:
                        iButton = 1;
                        break;
                    case 2:
                        iButton = 2;
                        break;
                    case 3:
                        iButton = 3;
                        break;
                }
            }else if (iCounter == 19){
                iButton = 1;
            }else if (iCounter == 20){
                iButton = 1;
            }
        }
        else if(i == 1){
            if(iCounter == 0 || iCounter == 4 || iCounter == 8 || iCounter == 12 || iCounter == 16){
                Random r = new Random();
                switch (r.nextInt(4 - 1) + 1){
                    case 1:
                        iButton = 1;
                        break;
                    case 2:
                        iButton = 2;
                        break;
                    case 3:
                        iButton = 3;
                        break;
                }
            }else if (iCounter == 1 || iCounter == 5 || iCounter == 9 || iCounter == 13 || iCounter == 17){
                iButton = 3;
            }else if (iCounter == 2 || iCounter == 6 || iCounter == 10 || iCounter == 14 || iCounter == 18){
                iButton = 2;
            }else if (iCounter == 3 || iCounter == 7 || iCounter == 11 || iCounter == 15){
                iButton = 1;
            }else if (iCounter == 19){
                iButton = 1;
            }else if (iCounter == 20) {
                iButton = 1;
            }
        }
                Clicked(iButton);
        switch (iButton){
            case 1:
                btnAdd4.setBackgroundResource(R.drawable.button03);
                break;
            case 2:
                btnAdd5.setBackgroundResource(R.drawable.button03);
                break;
            case 3:
                btnAdd6.setBackgroundResource(R.drawable.button03);
                break;
        }
            }
        }, 300);
        Handler handler7 = new Handler();
        handler7.postDelayed(new Runnable() {
            public void run() {
                btnAdd4.setBackgroundResource(R.drawable.button04);
                btnAdd5.setBackgroundResource(R.drawable.button04);
                btnAdd6.setBackgroundResource(R.drawable.button04);

            }
        }, 600);
    }
    public void ChangeButtons (int i){
        if(i == 1){
            btnAdd1.setText(String.valueOf(iCounter + 1));
            btnAdd2.setText((iCounter + 1) + " " + (iCounter + 2));
            btnAdd3.setText((iCounter + 1) + " " + (iCounter + 2) + " " + (iCounter + 3));
        }else if (i == 0){
            btnAdd4.setText(String.valueOf(iCounter + 1));
            btnAdd5.setText((iCounter + 1) + " " + (iCounter + 2));
            btnAdd6.setText((iCounter + 1) + " " + (iCounter + 2) + " " + (iCounter + 3));
        }
    }

    @Override
    public void onBackPressed() {

    }
}