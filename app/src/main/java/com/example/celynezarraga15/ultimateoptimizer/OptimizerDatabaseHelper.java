package com.example.celynezarraga15.ultimateoptimizer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by celynezarraga15 on 23/11/2016.
 */
public class OptimizerDatabaseHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "Diet_Problem_Solver";
    private static final int DB_VERSION = 1;

    public OptimizerDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE NUTRITIONAL_VALUES ("
        + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "FOOD TEXT, "
        + "PRICE REAL, "
        + "SERVING_SIZE REAL, "
        + "CALORIES REAL, "
        + "CHOLESTEROL REAL, "
        + "TOTAL_FAT REAL, "
        + "SODIUM REAL, "
        + "CARBOHYDRATES REAL, "
        + "DIETARY_FIBER REAL, "
        + "PROTEIN REAL, "
        + "VIT_A REAL, "
        + "VIT_C REAL, "
        + "CALCIUM REAL, "
        + "IRON REAL);");

        insertFood(db, "Frozen Broccoli", 0.16f, "10 Oz Pkg", 73.8f, 0f, 0.8f, 68.2f, 13.6f, 8.5f, 8f, 5867.4f, 160.2f, 159f, 2.3f);
        insertFood(db, "Raw Carrots", 0.07f, "1/2 Cup Shredded", 23.7f, 0f, 0.1f, 19.2f, 5.6f, 1.6f, 0.6f, 15471f, 5.1f, 14.9f, 0.3f);
        insertFood(db, "Raw Celery", 0.04f, "1 Stalk", 6.4f, 0f, 0.1f, 34.8f, 1.5f, 0.7f, 0.3f, 53.6f, 2.8f, 16f, 0.2f);
        insertFood(db, "Frozen Corn", 0.18f, "1/2 Cup", 72.2f, 0f, 0.6f, 2.5f, 17.1f, 2f, 2.5f, 106.6f, 5.2f, 3.3f, 0.3f);
        insertFood(db, "Raw Iceberg Lettuce", 0.02f, "1 Leaf", 2.6f, 0f, 0f, 1.8f, 0.4f, 0.3f, 0.2f, 66f, 0.8f, 3.8f, 0.1f);
        insertFood(db, "Raw Sweet Pepper", 0.53f, "1 Pepper", 20f, 0f, 0.1f, 1.5f, 4.8f, 1.3f, 0.7f, 467.7f, 66.1f, 6.7f, 0.3f);
        insertFood(db, "Baked Potatoes", 0.06f, "1/2 Cup", 171.5f, 0f, 0.2f, 15.2f, 39.9f, 3.2f, 3.7f, 0f, 15.6f, 22.7f, 4.3f);
        insertFood(db, "Tofu", 0.31f, "1/4 block", 88.2f, 0f, 5.5f, 8.1f, 2.2f, 1.4f, 9.4f, 98.6f, 0.1f, 121.8f, 6.20f);
        insertFood(db, "Roasted Chicken", 0.84f, "1 lb chicken", 277.4f, 129.9f, 10.8f, 125.6f, 0f, 0f, 42.2f, 77.4f, 0f, 21.9f, 1.8f);
        insertFood(db, "Spaghetti with Sauce", 0.78f, "1 1/2 Cup", 358.2f, 0f, 12.3f, 1237.1f, 58.3f, 11.6f, 8.2f, 3055.2f, 27.9f, 80.2f, 2.3f);
        insertFood(db, "Tomato", 0.27f, "1 Tomato, 2-3/5 In", 25.8f, 0f, 0.4f, 11.1f, 5.7f, 1.4f, 1f, 766.3f, 23.5f, 6.2f, 0.6f);
        insertFood(db, "Apple", 0.24f, "1 Fruit, 3/Lb, Wo/Rf", 81.4f, 0f, 0.5f, 0f, 21f, 3.7f, 0.3f, 73.1f, 7.9f, 9.7f, 0.2f);
        insertFood(db, "Banana", 0.15f, "1 Fruit, Wo/Skn&Seeds", 104.9f, 0f, 0.5f, 1.1f, 26.7f, 2.7f, 1.2f, 92.3f, 10.4f, 6.8f, 0.4f);
        insertFood(db, "Grapes", 0.32f, "10 Fruits, Wo/Rf", 15.1f, 0f, 0.1f, 0.5f, 4.1f, 0.2f, 0.2f, 24f, 1f, 3.4f, 0.1f);
        insertFood(db, "Kiwifruit", 0.49f, "1 Med Frt, Wo/Skn", 46.4f, 0f, 0.3f, 3.8f, 11.3f, 2.6f, 0.8f, 133f, 74.5f, 19.8f, 0.3f);
        insertFood(db, "Oranges", 0.15f, "1 Frt, 2-5/8f, Diam", 61.6f, 0f, 0.2f, 0f, 15.4f, 3.1f, 1.2f, 268.6f, 69.7f, 52.4f, 0.1f);
        insertFood(db, "Bagels", 0.16f, "1 Oz", 78f, 0f, 0.5f, 151.4f, 15.1f, 0.6f, 3f, 0f, 0f, 21f, 1f);
        insertFood(db, "Wheat Bread", 0.05f, "1 Sl", 65f, 0f, 1f, 134.5f, 12.4f, 1.3f, 2.2f, 0f, 0f, 10.8f, 0.7f);
        insertFood(db, "White Bread", 0.06f, "1 Sl", 65f, 0f, 1f, 132.5f, 11.8f, 1.1f, 2.3f, 0f, 0f, 26.2f, 0.8f);
        insertFood(db, "Oatmeal Cookies", 0.09f, "1 Cookie", 81f, 0f, 3.3f, 68.9f, 12.4f, 0.6f, 1.1f, 2.9f, 0.1f, 6.7f, 0.5f);
        insertFood(db, "Apple Pie", 0.16f, "1 Oz", 67.2f, 0f, 3.1f, 75.4f, 9.6f, 0.5f, 0.5f, 35.2f, 0.9f, 3.1f, 0.1f);
        insertFood(db, "Chocolate Chip Cookies", 0.03f, "1 Cookie", 78.1f, 5.1f, 4.5f, 57.8f, 9.3f, 0f, 0.9f, 101.8f, 0f, 6.2f, 0.4f);
        insertFood(db, "Regular Butter", 0.05f, "1 Pat", 35.8f, 10.9f, 4.1f, 41.3f, 0f, 0f, 0f, 152.9f, 0f, 1.2f, 0f);
        insertFood(db, "Cheddar Cheese", 0.25f, "1 Oz", 112.7f, 29.4f, 9.3f, 173.7f, 0.4f, 0f, 7f, 296.5f, 0f, 202f, 0.2f);
        insertFood(db, "3.3% Fat Whole Milk", 0.16f, "1 C", 149.9f, 33.2f, 8.1f, 119.6f, 11.4f, 0f, 8f, 307.4f, 2.3f, 291.3f, 0.1f);
        insertFood(db, "2% Lowfat Milk", 0.23f, "1 C", 121.2f, 18.3f, 4.7f, 121.8f, 11.7f, 0f, 8.1f, 500.2f, 2.3f, 296.7f, 0.1f);
        insertFood(db, "Skim Milk", 0.13f, "1 C", 85.5f, 4.4f, 0.4f, 126.2f, 11.9f, 0f, 8.4f, 499.8f, 2.4f, 302.3f, 0.1f);
        insertFood(db, "Poached Eggs", 0.08f, "Lrg Egg", 74.5f, 211.5f, 5f, 140f, 0.6f, 0f, 6.2f, 316f, 0f, 24.5f, 0.7f);
        insertFood(db, "Scrambled Eggs", 0.11f, "1 Egg", 99.6f, 211.2f, 7.3f, 168f, 1.3f, 0f, 6.7f, 409.2f, 0.1f, 42.6f, 0.7f);
        insertFood(db, "Turkey Bologna", 0.15f, "1 Oz", 56.4f, 28.1f, 4.3f, 248.9f, 0.3f, 0f, 3.9f, 0f, 0f, 23.8f, 0.4f);
        insertFood(db, "Frankfurter Beef", 0.27f, "1 Frankfurter", 141.8f, 27.4f, 12.8f, 461.7f, 0.8f, 0f, 5.4f, 0f, 10.8f, 9f, 0.6f);
        insertFood(db, "Extra Lean Sliced Ham", 0.33f, "1 Sl, 6-1/4x4x1/16f, In", 37.1f, 13.3f, 1.4f, 405.1f, 0.3f, 0f, 5.5f, 0f, 7.4f, 2f, 0.2f);
        insertFood(db, "Kielbassa Pork", 0.15f, "1 Sl, 6x3/4x1/16f, In", 80.6f, 17.4f, 7.1f, 279.8f, 0.6f, 0f, 3.4f, 0f, 5.5f, 11.4f, 0.4f);
        insertFood(db, "Cap'N Crunch", 0.31f, "1 Oz", 119.6f, 0f, 2.6f, 213.3f, 23f, 0.5f, 1.4f, 40.6f, 0f, 4.8f, 7.5f);
        insertFood(db, "Cheerios", 0.28f, "1 Oz", 111f, 0f, 1.8f, 307.6f, 19.6f, 2f, 4.3f, 1252.2f, 15.1f, 48.6f, 4.5f);
        insertFood(db, "Corn Flakes, Kellogg's", 0.28f, "1 Oz", 110.5f, 0f, 0.1f, 290.5f, 24.5f, 0.7f, 2.3f, 1252.2f, 15.1f, 0.9f, 1.8f);
        insertFood(db, "Raisin Bran, Kellogg's", 0.34f, "1.3f, Oz", 115.1f, 0f, 0.7f, 204.4f, 27.9f, 4f, 4f, 1250.2f, 0f, 12.9f, 16.8f);
        insertFood(db, "Rice Krispies", 0.32f, "1 Oz", 112.2f, 0f, 0.2f, 340.8f, 24.8f, 0.4f, 1.9f, 1252.2f, 15.1f, 4f, 1.8f);
        insertFood(db, "Special K", 0.38f, "1 Oz", 110.8f, 0f, 0.1f, 265.5f, 21.3f, 0.7f, 5.6f, 1252.2f, 15.1f, 8.2f, 4.5f);
        insertFood(db, "Oatmeal", 0.82f, "1 C", 145.1f, 0f, 2.3f, 2.3f, 25.3f, 4f, 6.1f, 37.4f, 0f, 18.7f, 1.6f);
        insertFood(db, "Malt-O-Meal Chocolate", 0.52f, "1 C", 607.2f, 0f, 1.5f, 16.5f, 128.2f, 0f, 17.3f, 0f, 0f, 23.1f, 47.2f);
        insertFood(db, "Pizza with Pepperoni", 0.44f, "1 Slice", 181f, 14.2f, 7f, 267f, 19.9f, 0f, 10.1f, 281.9f, 1.6f, 64.6f, 0.9f);
        insertFood(db, "Taco", 0.59f, "1 Small Taco", 369.4f, 56.4f, 20.6f, 802f, 26.7f, 0f, 20.7f, 855f, 2.2f, 220.6f, 2.4f);
        insertFood(db, "Hamburger with Toppings", 0.83f, "1 Burger", 275f, 42.8f, 10.2f, 563.9f, 32.7f, 0f, 13.6f, 126.3f, 2.6f, 51.4f, 2.5f);
        insertFood(db, "Hotdog", 0.31f, "1 Hotdog", 242.1f, 44.1f, 14.5f, 670.3f, 18f, 0f, 10.4f, 0f, 0.1f, 23.5f, 2.3f);
        insertFood(db, "Couscous", 0.39f, "1/2f, Cup", 100.8f, 0f, 0.1f, 4.5f, 20.9f, 1.3f, 3.4f, 0f, 0f, 7.2f, 0.3f);
        insertFood(db, "White Rice", 0.08f, "1/2f, Cup", 102.7f, 0f, 0.2f, 0.8f, 22.3f, 0.3f, 2.1f, 0f, 0f, 7.9f, 0.9f);
        insertFood(db, "Macaroni, Ckd", 0.17f, "1/2f, Cup", 98.7f, 0f, 0.5f, 0.7f, 19.8f, 0.9f, 3.3f, 0f, 0f, 4.9f, 1f);
        insertFood(db, "Peanut Butter", 0.07f, "2f, Tbsp", 188.5f, 0f, 16f, 155.5f, 6.9f, 2.1f, 7.7f, 0f, 0f, 13.1f, 0.6f);
        insertFood(db, "Pork", 0.81f, "4f, Oz", 710.8f, 105.1f, 72.2f, 38.4f, 0f, 0f, 13.8f, 14.7f, 0f, 59.9f, 0.4f);
        insertFood(db, "Sardines in Oil", 0.45f, "2f, Sardines", 49.9f, 34.1f, 2.7f, 121.2f, 0f, 0f, 5.9f, 53.8f, 0f, 91.7f, 0.7f);
        insertFood(db, "White Tuna in Water", 0.69f, "3f, Oz", 115.6f, 35.7f, 2.1f, 333.2f, 0f, 0f, 22.7f, 68f, 0f, 3.4f, 0.5f);
        insertFood(db, "Air-Popped Popcorn", 0.04f, "1 Oz", 108.3f, 0f, 1.2f, 1.1f, 22.1f, 4.3f, 3.4f, 55.6f, 0f, 2.8f, 0.8f);
        insertFood(db, "Potato Chips Barbecue Flavor", 0.22f, "1 Oz", 139.2f, 0f, 9.2f, 212.6f, 15f, 1.2f, 2.2f, 61.5f, 9.6f, 14.2f, 0.5f);
        insertFood(db, "Pretzels", 0.12f, "1 Oz", 108f, 0f, 1f, 486.2f, 22.5f, 0.9f, 2.6f, 0f, 0f, 10.2f, 1.2f);
        insertFood(db, "Tortilla Chip", 0.19f, "1 Oz", 142f, 0f, 7.4f, 149.7f, 17.8f, 1.8f, 2f, 55.6f, 0f, 43.7f, 0.4f);
        insertFood(db, "Chicken Noodle Soup", 0.39f, "1 C (8f, Fl Oz)", 150.1f, 12.3f, 4.6f, 1862.2f, 18.7f, 1.5f, 7.9f, 1308.7f, 0f, 27.1f, 1.5f);
        insertFood(db, "Split Pea and Ham Soup", 0.67f, "1 C (8f, Fl Oz)", 184.8f, 7.2f, 4f, 964.8f, 26.8f, 4.1f, 11.1f, 4872f, 7f, 33.6f, 2.1f);
        insertFood(db, "Vegetable Beef Soup", 0.71f, "1 C (8f, Fl Oz)", 158.1f, 10f, 3.8f, 1915.1f, 20.4f, 4f, 11.2f, 3785.1f, 4.8f, 32.6f, 2.2f);
        insertFood(db, "New England Clam Chowder", 0.75f, "1 C (8f, Fl Oz)", 175.7f, 10f, 5f, 1864.9f, 21.8f, 1.5f, 10.9f, 20.1f, 4.8f, 82.8f, 2.8f);
        insertFood(db, "Tomato Soup", 0.39f, "1 C (8f, Fl Oz)", 170.7f, 0f, 3.8f, 1744.4f, 33.2f, 1f, 4.1f, 1393f, 133f, 27.6f, 3.5f);
        insertFood(db, "New England Clam Chowder with Milk", 0.99f, "1 C (8f, Fl Oz)", 163.7f, 22.3f, 6.6f, 992f, 16.6f, 1.5f, 9.5f, 163.7f, 3.5f, 186f, 1.5f);
        insertFood(db, "Cream Mushroom Soup", 0.65f, "1 C (8f, Fl Oz)", 203.4f, 19.8f, 13.6f, 1076.3f, 15f, 0.5f, 6.1f, 153.8f, 2.2f, 178.6f, 0.6f);
        insertFood(db, "Bean with Bacon Soup", 0.67f, "1 C (8f, Fl Oz)", 172f, 2.5f, 5.9f, 951.3f, 22.8f, 8.6f, 7.9f, 888f, 1.5f, 81f, 2f);
    }

    public static void insertFood(SQLiteDatabase db, String name, Float price, String servingSize, Float calories, Float cholesterol, Float totalFat, Float sodium, Float carbohydrates, Float dietaryFiber, Float protein, Float vitA, Float vitC, Float calcium, Float iron){
        ContentValues foodValues = new ContentValues();
        foodValues.put("FOOD", name);
        foodValues.put("PRICE", price);
        foodValues.put("SERVING_SIZE", servingSize);
        foodValues.put("CALORIES", calories);
        foodValues.put("CHOLESTEROL", cholesterol);
        foodValues.put("TOTAL_FAT", totalFat);
        foodValues.put("SODIUM", sodium);
        foodValues.put("CARBOHYDRATES", carbohydrates);
        foodValues.put("DIETARY_FIBER", dietaryFiber);
        foodValues.put("PROTEIN", protein);
        foodValues.put("VIT_A", vitA);
        foodValues.put("VIT_C", vitC);
        foodValues.put("CALCIUM", calcium);
        foodValues.put("IRON", iron);

        db.insert("NUTRITIONAL_VALUES",null,foodValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
