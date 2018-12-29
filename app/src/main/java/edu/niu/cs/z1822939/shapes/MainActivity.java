package edu.niu.cs.z1822939.shapes;

/* Name: Gayathri Sanikommu   zid: z1822939
   Course: CSCI 522
   Purpose: To calculate the area of different shapes
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    private RadioGroup shapesRG;
    private TextView areaTV,resultTitleTV;
    private Button calculationButton;

    int ShapeId=99;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shapesRG = (RadioGroup)findViewById(R.id.shapeRadioGroup);

        resultTitleTV = (TextView)findViewById(R.id.resultTitleTextView);

        areaTV = (TextView)findViewById(R.id.areaTextView);

        calculationButton = (Button)findViewById(R.id.calculationButton);

        shapesRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                switch (i)
                {
                    case R.id.triangleRadioButton: ShapeId = 1;
                        break;

                    case R.id.circleRadioButton: ShapeId = 2;
                        break;

                    case R.id.ellipseRadioButton: ShapeId = 3;
                        break;
                }

            }
        });


        calculationButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(ShapeId==1)
                {
                    Intent intent = new Intent(MainActivity.this, Shape.class);
                    intent.putExtra("Id",ShapeId);
                    startActivity(intent);
                }
                else if(ShapeId==2)
                {
                    Intent intent = new Intent(MainActivity.this, Shape.class);
                    intent.putExtra("Id",ShapeId);
                    startActivity(intent);
                }
                else if(ShapeId == 3)
                {

                    Intent intent = new Intent (MainActivity.this, Shape.class);
                    intent.putExtra("Id",ShapeId);
                    startActivity(intent);
                }else if(ShapeId == 99)
                {
                    Toast.makeText(view.getContext(),"Choose a option first",Toast.LENGTH_LONG).show();
                }

            }
        });


    }//End onCreate

    protected void onResume() {
        super.onResume();

        Intent newIntent = getIntent();
        DecimalFormat formatting = new DecimalFormat("0.000");
        Double triangleArea = newIntent.getDoubleExtra("triangleArea",0);
        Double circleArea = newIntent.getDoubleExtra("circleArea",0);
        Double ellipseArea = newIntent.getDoubleExtra("ellipseArea",0);

        if(triangleArea!=0)
        {
            resultTitleTV.setText(getResources().getString(R.string.triangleTitle));
            areaTV.setText(formatting.format(triangleArea));
        }else if(circleArea!=0)
        {
            resultTitleTV.setText(getResources().getString(R.string.circleTitle));
            areaTV.setText(formatting.format(circleArea));
        }else if(ellipseArea!=0)
        {
            resultTitleTV.setText(getResources().getString(R.string.ellipseTitle));
            areaTV.setText(formatting.format(ellipseArea));
        }else
        {
            areaTV.setText("Calculated area will display here");
        }

    }//End onResume
}
