package com.example.syntheticcloudversion4;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by tom on 8/21/2016.
 */
public class CustomSwipeAdapter extends PagerAdapter{

    private int[] image_resources = {R.drawable.image_1,R.drawable.image_2,R.drawable.image_3,R.drawable.image_4,R.drawable.image_5,R.drawable.image_6};
    private Context ctx;
    private LayoutInflater layoutInflater;
    private String[] text = {"\"Aeolus Lite - Fire Engine Red \\n\n" +
            "$42.00\n" +
            "\\n\n" +
            "• Vertical Airflow System \\n\n" +
            "• Anti-Leak System \\n\n" +
            "• PEEK Insulators (649.4°F) \\n\n" +
            "• Unparalleled Flavor \\n\n" +
            "• Wide Range of Airflow Configurations \\n\n" +
            "• Additional Small Airholes for Tighter Draws \\n\n" +
            "• Anti-Spin Square Centerpost \\n\n" +
            "• Large Post Holes \\n\n" +
            "• 18K Gold-Plated Brass Contacts \\n\n" +
            "• Top Cap, Barrel, and AFC: Anodized Aluminum \\n\n" +
            "• 22 mm Diameter\n" +
            "\"","Spectra Box Mod (Black/Black)\n" +
            "$90.00\n" +
            "\n" +
            "Specifications:\n" +
            "• Chip: SBT-200UTC\n" +
            "• Max Wattage: 200W\n" +
            "• Temperature Control Support: Kanthal A-1, Ni200, Titanium, SS\n" +
            "• Resistance Support: 0.04Ω - 2.0Ω\n" +
            "• Temperature Range: 200°F - 600°F/100°C - 300°C\n" +
            "• Battery Requirement: (2) - 18650 35Amp*\n" +
            "• Chip Update Requirement: Microchip PICkit 3*\n" +
            "\n" +
            "Features:\n" +
            "• Spring Electrode\n" +
            "• Magnet Cover\n" +
            "• Input High Voltage Warning\n" +
            "• Low Voltage Protection\n" +
            "• Low Resistance Protection\n" +
            "• Output Short-Circuit Protection\n" +
            "• Reverse Battery Protection\n" +
            "• Overheating Protection\n" +
            "• Overtime Protection\n","HeavyWeight v2 by Vault Mods\n" +
            "$95.00\n" +
            "\n" +
            "The Heavyweight V2 is similar to the V1 as it emulates the same American cowboy roots with its rugged undertones paired alongside a unique yet elegant body. However, hidden beneath its admirable aesthetics is a new custom 200W chip that renovates its traditional functionality with a refreshing modernization. This dual 18650 box mod supports Ni200, Titanium, and Stainless Steel wire with a resistance support of 0.05Ω - 2.5Ω and temperature support of 212°F-662°F/100°C-350°C.",
            "Aeolus Lite - Teal\n" +
                    "$42.00" +
                    "\n" +
                    "• Vertical Airflow System\n" +
                    "• Anti-Leak System\n" +
                    "• PEEK Insulators (649.4°F)\n" +
                    "• Unparalleled Flavor\n" +
                    "• Wide Range of Airflow Configurations\n" +
                    "• Additional Small Airholes for Tighter Draws\n" +
                    "• Anti-Spin Square Centerpost\n" +
                    "• Large Post Holes\n" +
                    "• 18K Gold-Plated Brass Contacts\n" +
                    "• Top Cap, Barrel, and AFC: Anodized Aluminum\n" +
                    "• 22 mm Diameter\n",
            "Aeolus Lite - Gold \n" +
                    "$42.00\n" +
                    "• Vertical Airflow System\n" +
                    "• Anti-Leak System\n" +
                    "• PEEK Insulators (649.4°F)\n" +
                    "• Unparalleled Flavor\n" +
                    "• Wide Range of Airflow Configurations\n" +
                    "• Additional Small Airholes for Tighter Draws\n" +
                    "• Anti-Spin Square Centerpost\n" +
                    "• Large Post Holes\n" +
                    "• 18K Gold-Plated Brass Contacts\n" +
                    "• Top Cap, Barrel, and AFC: Anodized Aluminum\n" +
                    "• 22 mm Diameter\n","G.O.A.T - Strawberry Fire \n" +
            "$20.00\n" +
            "A berry scrumptious homemade strawberry pie made with freshly ripened strawberries right off the vine and a flaky pie crust that crumbles in your mouth.\n"};

    public CustomSwipeAdapter (Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView = (ImageView)item_view.findViewById(R.id.image_view);
        TextView textView = (TextView)item_view.findViewById(R.id.image_count);
        imageView.setImageResource(image_resources[position]);
        textView.setText(text[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
