package ir.dotin.entity;

import ir.dotin.da.CategoryDA;

import java.util.Arrays;

public class CategoryTest {

    public static void main(String[] args) {
        addPersonRoleCategory();
        addOffRequestCategory();
    }

    private static void addOffRequestCategory() {
        Category category = new Category();
        category.setCategoryName("OffRequestType");
        category.setCategoryFarsiName("نوع درخواست مرخصی");

        SubCategory subCategory = new SubCategory();
        subCategory.setSubCategoryName("Hourly");
        subCategory.setSubCategoryFarsiName("ساعتی");
        subCategory.setMainCategory(category);


        SubCategory subCategory2 = new SubCategory();
        subCategory2.setSubCategoryName("Daily");
        subCategory2.setSubCategoryFarsiName("روزانه");
        subCategory2.setMainCategory(category);

        if (category.getSubCategories() != null) {
            category.getSubCategories().addAll(Arrays.asList(subCategory, subCategory2));
        } else {
            category.setSubCategories(Arrays.asList(subCategory, subCategory2));
        }

        CategoryDA categoryDA = new CategoryDA();
        categoryDA.addCategory(category);


    }


    private static void addPersonRoleCategory() {
        CategoryDA categoryDA = new CategoryDA();
        Category category = new Category();
        category.setCategoryName("PersonRole");
        category.setCategoryFarsiName("شغل شخص");

        SubCategory developer = new SubCategory();
        SubCategory tester = new SubCategory();

        developer.setSubCategoryName("Developer");
        developer.setSubCategoryFarsiName("برنامه نویس");
        tester.setSubCategoryName("Tester");
        tester.setSubCategoryFarsiName("تستر");

        category.setSubCategories(Arrays.asList(developer, tester));

        developer.setMainCategory(category);
        tester.setMainCategory(category);

        categoryDA.addCategory(category);
    }
}