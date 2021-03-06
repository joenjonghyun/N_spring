package kr.co.patternbot.common.dataStructure;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class BmiList {
    public static void main(String[] args) {

    }
    @Data
    static class Bmi{
        private double height, weight;
        private String ssn, gender;
    }
    interface BmiService{
        void save(Bmi bmi);
        void update(Bmi bmi);
        void delete(Bmi bmi);
        List<Bmi> findAll();
        List<Bmi> findByGender(String gender);
        Bmi findByID(int i);
        int count();
        void clear();

    }
    static class BmiServiceImpl implements BmiService{
        private final List<Bmi> list;

        public BmiServiceImpl() {
            this.list = new ArrayList<>();
        }

        @Override
        public void save(Bmi bmi) {

        }

        @Override
        public void update(Bmi bmi) {

        }

        @Override
        public void delete(Bmi bmi) {

        }

        @Override
        public List<Bmi> findAll() {
            return null;
        }

        @Override
        public List<Bmi> findByGender(String gender) {
            return null;
        }

        @Override
        public Bmi findByID(int i) {
            return null;
        }

        @Override
        public int count() {
            return 0;
        }

        @Override
        public void clear() {

        }
    }
}