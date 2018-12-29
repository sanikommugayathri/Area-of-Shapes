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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Shape extends Activity {

    EditText dimension1ET,dimension2ET;
    TextView title,dimension1TV,dimension2TV;
    Button calculateBtn;
    Double triangleArea, circleArea, ellipseArea, radius, major, minor, base, height;
    static final double pi=3.14159;
    int shapeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);


        dimension1ET = (EditText) findViewById(R.id.dimension1EditText);
        dimension2ET = (EditText) findViewById(R.id.dimension2EditText);
        dimension1TV = (TextView) findViewById(R.id.dimension1TextView);
        dimension2TV = (TextView) findViewById(R.id.dimension2Textview);
        title = (TextView) findViewById(R.id.titleTextView);
        calculateBtn = (Button) findViewById(R.id.calculateButton);

        Intent intent = getIntent();

        shapeId = intent.getIntExtra("Id",0);


        if( shapeId == 1 )
        {
            title.setText(getResources().getString(R.string.triangle));
            dimension1TV.setText(getResources().getString(R.string.base));
            dimension2TV.setText(getResources().getString(R.string.height));
        }else if (shapeId == 2)
        {
            title.setText(getResources().getString(R.string.circle));
            dimension1TV.setText(getResources().getString(R.string.radius));
            dimension2ET.setText("Nothing");
            dimension2ET.setVisibility(View.GONE);
        }else if (shapeId == 3)
        {
            title.setText(getResources().getString(R.string.ellipse));
            dimension1TV.setText(getResources().getString(R.string.major));
            dimension2TV.setText(getResources().getString(R.string.minor));
        }

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( dimension1ET.getText().toString().matches("") || dimension2ET.getText().toString().matches(""))
                {
                    Toast.makeText(v.getContext(),"Enter Values",Toast.LENGTH_LONG).show();
                    return;
                }else if(dimension1ET.getText().toString().matches("0") || dimension2ET.getText().toString().matches("0"))
                {
                    Toast.makeText(v.getContext(),"Dimensions cannot be Zero",Toast.LENGTH_LONG).show();
                    return;
                }

                if( shapeId == 1 )
                {
                    base = Double.parseDouble(dimension1ET.getText().toString());
                    height = Double.parseDouble(dimension2ET.getText().toString());
                    triangleArea = 0.5 * base * height;
                    Intent newIntent = new Intent(Shape.this, MainActivity.class);
                    newIntent.putExtra("triangleArea",triangleArea);
                    startActivity(newIntent);
                }else if (shapeId == 2)
                {
                    radius = Double.parseDouble(dimension1ET.getText().toString());
                    circleArea = pi * radius * radius;
                    Intent newIntent = new Intent(Shape.this, MainActivity.class);
                    newIntent.putExtra("circleArea",circleArea);
                    startActivity(newIntent);

                }else if (shapeId == 3)
                {
                    major = Double.parseDouble(dimension1ET.getText().toString());
                    minor = Double.parseDouble(dimension2ET.getText().toString());
                    ellipseArea = pi * minor * major;
                    Intent newIntent = new Intent(Shape.this, MainActivity.class);
                    newIntent.putExtra("ellipseArea",ellipseArea);
                    startActivity(newIntent);

                }

            }
        });


    }//End onCreate
}
