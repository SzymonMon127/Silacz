package com.sm.healthy_man;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class TrainingActivity extends AppCompatActivity {


    public static final String EXTRA_TRAINING_ID = "trainingId";

    private int Diet1;
    private int Training1;

    private String id;

    private FirebaseDatabase firebaseDatabase;
    private int trainingId;
    private int trainingLenght;
    private TextView textView;




    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        firebaseDatabase = FirebaseDatabase.getInstance();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {

            getNameAndId();
            ReadOrInitFromFirebase1();
        }
         trainingId = (Integer)getIntent().getExtras().get(EXTRA_TRAINING_ID);

        textView = findViewById(R.id.textDay);
        textView.setText( "Dzień " + (trainingId+1));

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }


    public int getTrainingId() {
        return trainingId;
    }

    private void getNameAndId()
    {
        String  idNumber;
        String firebaseEmail = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName();
        String userName = StringUtils.substringBefore(firebaseEmail, "@");
        idNumber = FirebaseAuth.getInstance().getCurrentUser().getUid();
        id = userName + idNumber;
    }

    private void ReadOrInitFromFirebase1() {

        try {
            firebaseDatabase.getReference().child("users").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if ((int) dataSnapshot.getChildrenCount() != 0) {
                        Person newPerson = dataSnapshot.getValue(Person.class);

                        assert newPerson != null;
                        Training1 = newPerson.Training;
                        Diet1 = newPerson.Diet;

                        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
                        ViewPager pager = (ViewPager) findViewById(R.id.pager);
                        pager.setAdapter(pagerAdapter);
                    } else {
                        Toast.makeText(TrainingActivity.this, "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e) {
            Toast.makeText(TrainingActivity.this, "Błąd z bazą danych", Toast.LENGTH_SHORT).show();
        }
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public int getCount() {
                    getTrainingLenght(Training1, Diet1);
                    return trainingLenght;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
                switch (position)
                {
                    case 0:

                        return new TrainingDetailFragment1();
                    case 1:
                        return new TrainingDetailFragment2();
                    case 2:

                        return new TrainingDetailFragment3();
                    case 3:

                        return new TrainingDetailFragment4();
                    case 4:

                        return new TrainingDetailFragment5();
                    case 5:

                        return new TrainingDetailFragment6();
                    case 6:

                        return new TrainingDetailFragment7();
                    case 7:

                        return new TrainingDetailFragment8();
                    case 8:

                        return new TrainingDetailFragment9();
                    case 9:

                        return new TrainingDetailFragment10();
                    case 10:

                        return new TrainingDetailFragment11();
                    case 11:

                        return new TrainingDetailFragment12();
                }
            return null;
        }
    }

    public int trainingId() {
        return trainingId;
    }

    public int getDiet1() {
        return Diet1;
    }

    public int getTraining1() {
        return Training1;
    }

    private void getTrainingLenght (int Training1, int Diet1 ) {

        if (Diet1 == 1) {

            if (Training1 == 1) {
                if (TrainingDayReductionEasy.trainingDayReductionEasy[trainingId].getTraining11() == null) {
                    if (TrainingDayReductionEasy.trainingDayReductionEasy[trainingId].getTraining10() == null) {
                        if (TrainingDayReductionEasy.trainingDayReductionEasy[trainingId].getTraining9() == null) {
                            if (TrainingDayReductionEasy.trainingDayReductionEasy[trainingId].getTraining8() == null) {
                                if (TrainingDayReductionEasy.trainingDayReductionEasy[trainingId].getTraining7() == null) {
                                    if (TrainingDayReductionEasy.trainingDayReductionEasy[trainingId].getTraining6() == null) {
                                        if (TrainingDayReductionEasy.trainingDayReductionEasy[trainingId].getTraining5() == null) {
                                            if (TrainingDayReductionEasy.trainingDayReductionEasy[trainingId].getTraining4() == null) {
                                                if (TrainingDayReductionEasy.trainingDayReductionEasy[trainingId].getTraining3() == null) {
                                                    if (TrainingDayReductionEasy.trainingDayReductionEasy[trainingId].getTraining2() == null) {
                                                        trainingLenght = 1;
                                                    } else {
                                                        trainingLenght = 2;
                                                    }
                                                } else {
                                                    trainingLenght = 3;
                                                }
                                            } else {
                                                trainingLenght = 4;
                                            }
                                        } else {
                                            trainingLenght = 5;
                                        }
                                    } else {
                                        trainingLenght = 6;
                                    }
                                } else {
                                    trainingLenght = 7;
                                }
                            } else {
                                trainingLenght = 8;
                            }
                        } else {
                            trainingLenght = 9;
                        }
                    } else {
                        trainingLenght = 10;
                    }
                } else {
                    trainingLenght = 11;
                }
            }

            if (Training1 == 2) {

                    if (TrainingDayReductionMedium.trainingDayReductionMedium[trainingId].getTraining11() == null) {
                        if (TrainingDayReductionMedium.trainingDayReductionMedium[trainingId].getTraining10() == null) {
                            if (TrainingDayReductionMedium.trainingDayReductionMedium[trainingId].getTraining9() == null) {
                                if (TrainingDayReductionMedium.trainingDayReductionMedium[trainingId].getTraining8() == null) {
                                    if (TrainingDayReductionMedium.trainingDayReductionMedium[trainingId].getTraining7() == null) {
                                        if (TrainingDayReductionMedium.trainingDayReductionMedium[trainingId].getTraining6() == null) {
                                            if (TrainingDayReductionMedium.trainingDayReductionMedium[trainingId].getTraining5() == null) {
                                                if (TrainingDayReductionMedium.trainingDayReductionMedium[trainingId].getTraining4() == null) {
                                                    if (TrainingDayReductionMedium.trainingDayReductionMedium[trainingId].getTraining3() == null) {
                                                        if (TrainingDayReductionMedium.trainingDayReductionMedium[trainingId].getTraining2() == null) {
                                                            trainingLenght = 1;
                                                        } else {
                                                            trainingLenght = 2;
                                                        }
                                                    } else {
                                                        trainingLenght = 3;
                                                    }
                                                } else {
                                                    trainingLenght = 4;
                                                }
                                            } else {
                                                trainingLenght = 5;
                                            }
                                        } else {
                                            trainingLenght = 6;
                                        }
                                    } else {
                                        trainingLenght = 7;
                                    }
                                } else {
                                    trainingLenght = 8;
                                }
                            } else {
                                trainingLenght = 9;
                            }
                        } else {
                            trainingLenght = 10;
                        }

                    } else {
                        trainingLenght = 11;
                    }

            }

            if (Training1 == 3) {
                if (TrainingDayReductionHard.trainingDayReductionHard[trainingId].getTraining11() == null) {
                    if (TrainingDayReductionHard.trainingDayReductionHard[trainingId].getTraining10() == null) {
                        if (TrainingDayReductionHard.trainingDayReductionHard[trainingId].getTraining9() == null) {
                            if (TrainingDayReductionHard.trainingDayReductionHard[trainingId].getTraining8() == null) {
                                if (TrainingDayReductionHard.trainingDayReductionHard[trainingId].getTraining7() == null) {
                                    if (TrainingDayReductionHard.trainingDayReductionHard[trainingId].getTraining6() == null) {
                                        if (TrainingDayReductionHard.trainingDayReductionHard[trainingId].getTraining5() == null) {
                                            if (TrainingDayReductionHard.trainingDayReductionHard[trainingId].getTraining4() == null) {
                                                if (TrainingDayReductionHard.trainingDayReductionHard[trainingId].getTraining3() == null) {
                                                    if (TrainingDayReductionHard.trainingDayReductionHard[trainingId].getTraining2() == null) {
                                                        trainingLenght = 1;
                                                    } else {
                                                        trainingLenght = 2;
                                                    }
                                                } else {
                                                    trainingLenght = 3;
                                                }
                                            } else {
                                                trainingLenght = 4;
                                            }
                                        } else {
                                            trainingLenght = 5;
                                        }
                                    } else {
                                        trainingLenght = 6;
                                    }
                                } else {
                                    trainingLenght = 7;
                                }
                            } else {
                                trainingLenght = 8;
                            }
                        } else {
                            trainingLenght = 9;
                        }
                    } else {
                        trainingLenght = 10;
                    }

                } else {
                    trainingLenght = 11;
                }
            }


        }

        if (Diet1 == 2) {
            if (Training1 == 1) {
                if (TrainingDayMassEasy.trainingDayMassEasy[trainingId].getTraining11() == null) {
                    if (TrainingDayMassEasy.trainingDayMassEasy[trainingId].getTraining10() == null) {
                        if (TrainingDayMassEasy.trainingDayMassEasy[trainingId].getTraining9() == null) {
                            if (TrainingDayMassEasy.trainingDayMassEasy[trainingId].getTraining8() == null) {
                                if (TrainingDayMassEasy.trainingDayMassEasy[trainingId].getTraining7() == null) {
                                    if (TrainingDayMassEasy.trainingDayMassEasy[trainingId].getTraining6() == null) {
                                        if (TrainingDayMassEasy.trainingDayMassEasy[trainingId].getTraining5() == null) {
                                            if (TrainingDayMassEasy.trainingDayMassEasy[trainingId].getTraining4() == null) {
                                                if (TrainingDayMassEasy.trainingDayMassEasy[trainingId].getTraining3() == null) {
                                                    if (TrainingDayMassEasy.trainingDayMassEasy[trainingId].getTraining2() == null) {
                                                        trainingLenght = 1;
                                                    } else {
                                                        trainingLenght = 2;
                                                    }
                                                } else {
                                                    trainingLenght = 3;
                                                }
                                            } else {
                                                trainingLenght = 4;
                                            }
                                        } else {
                                            trainingLenght = 5;
                                        }
                                    } else {
                                        trainingLenght = 6;
                                    }
                                } else {
                                    trainingLenght = 7;
                                }
                            } else {
                                trainingLenght = 8;
                            }
                        } else {
                            trainingLenght = 9;
                        }
                    } else {
                        trainingLenght = 10;
                    }

                } else {
                    trainingLenght = 11;
                }
            } else if (Training1 == 2) {
                if (TrainingDayMassMedium.trainingDayMassMedium[trainingId].getTraining12() == null) {
                    if (TrainingDayMassMedium.trainingDayMassMedium[trainingId].getTraining11() == null) {
                        if (TrainingDayMassMedium.trainingDayMassMedium[trainingId].getTraining10() == null) {
                            if (TrainingDayMassMedium.trainingDayMassMedium[trainingId].getTraining9() == null) {
                                if (TrainingDayMassMedium.trainingDayMassMedium[trainingId].getTraining8() == null) {
                                    if (TrainingDayMassMedium.trainingDayMassMedium[trainingId].getTraining7() == null) {
                                        if (TrainingDayMassMedium.trainingDayMassMedium[trainingId].getTraining6() == null) {
                                            if (TrainingDayMassMedium.trainingDayMassMedium[trainingId].getTraining5() == null) {
                                                if (TrainingDayMassMedium.trainingDayMassMedium[trainingId].getTraining4() == null) {
                                                    if (TrainingDayMassMedium.trainingDayMassMedium[trainingId].getTraining3() == null) {
                                                        if (TrainingDayMassMedium.trainingDayMassMedium[trainingId].getTraining2() == null) {
                                                            trainingLenght = 1;
                                                        } else {
                                                            trainingLenght = 2;
                                                        }
                                                    } else {
                                                        trainingLenght = 3;
                                                    }
                                                } else {
                                                    trainingLenght = 4;
                                                }
                                            } else {
                                                trainingLenght = 5;
                                            }
                                        } else {
                                            trainingLenght = 6;
                                        }
                                    } else {
                                        trainingLenght = 7;
                                    }
                                } else {
                                    trainingLenght = 8;
                                }
                            } else {
                                trainingLenght = 9;
                            }
                        } else {
                            trainingLenght = 10;
                        }
                    } else {
                        trainingLenght = 11;
                    }

                } else {
                    trainingLenght = 12;
                }
            } else if (Training1 == 3) {

                if (TrainingDayMassHard.trainingDayMassHard[trainingId].getTraining11() == null) {
                    if (TrainingDayMassHard.trainingDayMassHard[trainingId].getTraining10() == null) {
                        if (TrainingDayMassHard.trainingDayMassHard[trainingId].getTraining9() == null) {
                            if (TrainingDayMassHard.trainingDayMassHard[trainingId].getTraining8() == null) {
                                if (TrainingDayMassHard.trainingDayMassHard[trainingId].getTraining7() == null) {
                                    if (TrainingDayMassHard.trainingDayMassHard[trainingId].getTraining6() == null) {
                                        if (TrainingDayMassHard.trainingDayMassHard[trainingId].getTraining5() == null) {
                                            if (TrainingDayMassHard.trainingDayMassHard[trainingId].getTraining4() == null) {
                                                if (TrainingDayMassHard.trainingDayMassHard[trainingId].getTraining3() == null) {
                                                    if (TrainingDayMassHard.trainingDayMassHard[trainingId].getTraining2() == null) {
                                                        trainingLenght = 1;
                                                    } else {
                                                        trainingLenght = 2;
                                                    }
                                                } else {
                                                    trainingLenght = 3;
                                                }
                                            } else {
                                                trainingLenght = 4;
                                            }
                                        } else {
                                            trainingLenght = 5;
                                        }
                                    } else {
                                        trainingLenght = 6;
                                    }
                                } else {
                                    trainingLenght = 7;
                                }
                            } else {
                                trainingLenght = 8;
                            }
                        } else {
                            trainingLenght = 9;
                        }
                    } else {
                        trainingLenght = 10;
                    }

                } else {
                    trainingLenght = 11;
                }
            }

            }



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MediaPlayer clickAlert =MediaPlayer.create(TrainingActivity.this, R.raw.click);
        clickAlert.start();
    }
}