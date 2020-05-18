package com.lch;

import java.util.concurrent.locks.ReentrantLock;

public class Word26Test {

    public static ReentrantLock lock = new ReentrantLock(true);

    public static String[] words = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static volatile int wordIndex = 0;

    public static void main(String[] args) {
        TA a = new TA();
        Thread ta = new Thread(a);
        TB b = new TB();
        Thread tb = new Thread(b);
        if (words.length <= 0){
            System.out.println("数组不能为空");
            return;
        }

        ta.start();
        tb.start();

    }

    public static boolean isVowelWord(String word){
        if ("a".equals(word)){
            return true;
        }else if ("e".equals(word)){
            return true;
        }else if ("i".equals(word)){
            return true;
        }else if ("o".equals(word)){
            return true;
        }else if ("u".equals(word)) {
            return true;
        }
        return false;
    }

    private static class TA implements Runnable{

        @Override
        public void run() {
            wordIndex = 0;
            while (wordIndex < words.length){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.lock();

                System.out.println("线程TA：拿到锁");

                try {
                    for (;wordIndex < words.length;wordIndex++){
                        if (isVowelWord(words[wordIndex])){
                            System.out.println("我是TA：输出元音元音字母为：" + words[wordIndex]);
                        }else {
                            break;
                        }
                    }
                }catch (Exception e){

                }finally {
                    lock.unlock();
                    System.out.println("线程TA：释放锁");
                }


            }
        }
    }

    private static class TB implements Runnable{

        @Override
        public void run() {
            wordIndex = 0;
            while (wordIndex < words.length){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.lock();

                System.out.println("线程TB：拿到锁");

                try{
                    for (;wordIndex < words.length;wordIndex++){
                        if (!isVowelWord(words[wordIndex])){
                            System.out.println("我的TB：输出辅音字母为：" + words[wordIndex]);
                        }else {
                            break;
                        }
                    }

                }catch (Exception e){

                }finally {
                    lock.unlock();
                    System.out.println("线程TB：释放锁");
                }
            }
        }
    }


}
