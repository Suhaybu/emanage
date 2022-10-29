//ABDULMALIK ALBAKHEET
package com.xyzsoft.emanage;

import java.util.Arrays;

public class xlsMerge {

    public static void main(String[] args) {

        String project[][] = { { "005056AB1EC01EDBBFB4794AA6DE2B15", "005056AB1EC01EDBBFD057AF0C4A4B8D" },
                { "S-0001", "S-0002" }, { "7", "7" }, { "5/28/2021", "7/7/2021" }, { "6/2/2022", "1/16/2022" },
                { "1000000000", "1000000000" }, { "SAR", "SAR" }, { "15.08.2021 11:40:37", "16.08.2021 14:23:15" },
                { "17.02.2022 11:47:54", "28.03.2022 14:14:32" } };

        String stages[][] = {
                { "005056AB1EC01EDBBFB4794AA6DE2B15", "005056AB1EC01EDBBFB4794AA6DE2B15",
                        "005056AB1EC01EDBBFB4794AA6DE2B15", "005056AB1EC01EDBBFD057AF0C4A4B8D" },
                { "529813", "530181", "563919", "530597" }, { "J", "U", "U", "J" }, { "1", "6", "7", "1" },
                { "0", "1", "6", "0" } };

        String[][] stages_detailed = {
                { "005056AB1EC01EDBBFB4794AA6DE2B15", "005056AB1EC01EDBBFB4794AA6DE2B15",
                        "005056AB1EC01EDBBFB4794AA6DE2B15", "005056AB1EC01EDBBFD057AF0C4A4B8D" },
                { "529813", "530181", "563919", "530597" }, { "8/15/2021", "8/15/2021", "12/6/2021", "8/16/2021" },
                { "11:40:37 AM", "2:40:37 PM", "12:21:07 PM", "2:23:15 PM" } };

        String[][] merged = new String[15][stages[0].length];

        merging(project, stages, stages_detailed, merged);

        for (String[] e : merged) {
            System.out.println(Arrays.toString(e));
        }
    }

    private static void merging(String[][] project, String[][] stages, String[][] stages_detailed, String[][] merged) {
        for (int i = 0; i < project[0].length; i++) {
            for (int j = 0; j < stages[0].length; j++) {
                if (project[0][i].equals(stages[0][j])) {
                    merged[0][j] = stages[0][j]; // ID
                    merged[1][j] = project[1][i]; // customer project ID
                    merged[2][j] = project[2][i]; // stage
                    merged[3][j] = project[3][i]; // Start Date
                    merged[4][j] = project[4][i]; // End Date
                    merged[5][j] = project[5][i]; // customer
                    merged[6][j] = project[6][i]; // Currency
                    merged[7][j] = project[7][i]; // created on
                    merged[8][j] = project[8][i]; // changed on
                    merged[9][j] = stages[1][j]; // document No
                    merged[10][j] = stages[2][j]; // Change Indicator
                    merged[11][j] = stages[3][j]; // new value
                    merged[12][j] = stages[4][j]; // old value
                    merged[13][j] = stages_detailed[2][j]; // Date
                    merged[14][j] = stages_detailed[3][j]; // Time
                }
            }
        }
    }

}
