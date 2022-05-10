package kr.co.patternbot.common.dataStructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

public class ItemCRUD {
    public static void main(String[] args) {

    }
    @Data @AllArgsConstructor class Item{
        private int id;
        private String name;
        private int price;

    }
    interface ItemService{
        void save();
        void update();
        void delete();
        int count();

    }
    @RequiredArgsConstructor
    @Service
    class ItemServiceImpl implements ItemService{

        @Override
        public void save() {

        }

        @Override
        public void update() {

        }

        @Override
        public void delete() {

        }

        @Override
        public int count() {
            return 0;
        }
    }

}
