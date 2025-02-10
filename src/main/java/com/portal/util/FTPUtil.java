//package com.portal.util;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.List;
//
///**
// * @Author: tina.huanght
// * @Date: 10/02/25 11:37
// */
//public class FTPUtil {
//    private static String ftpIp = PropertiesUtil.getProperty("ftp.server.ip");
//    private static String ftpUser = PropertiesUtil.getProperty("ftp.user");
//    private static String ftpPass = PropertiesUtil.getProperty("ftp.pass");
//
//    private String ip;
//    private int port;
//    private String user;
//    private String pwd;
//    private FTPClient client;
//
//    public FTPUtil(String ip, int port, String user, String pwd) {
//        this.ip = ip;
//        this.port = port;
//        this.user = user;
//        this.pwd = pwd;
//    }
//    public static boolean uploadFile(List<File> fileList){
//        FTPUtil ftpUtil = new FTPUtil(ftpIp, 21, ftpUser, ftpPass);
//    }
//
//    private boolean uploadFile(String remotePath, List<File> fileList) throws IOException {
//        boolean uploaded = true;
//        FileInputStream fis = null;
//        //连接FTP
//    }
//    private boolean  connectServer(String ip, int port, String user, String pwd){
//        ftpClient = new FTPClient();
//        ftpClient.connect(ip);
//    }
//
//    public static String getFtpIp() {
//        return ftpIp;
//    }
//
//    public static void setFtpIp(String ftpIp) {
//        FTPUtil.ftpIp = ftpIp;
//    }
//
//    public static String getFtpUser() {
//        return ftpUser;
//    }
//
//    public static void setFtpUser(String ftpUser) {
//        FTPUtil.ftpUser = ftpUser;
//    }
//
//    public static String getFtpPass() {
//        return ftpPass;
//    }
//
//    public static void setFtpPass(String ftpPass) {
//        FTPUtil.ftpPass = ftpPass;
//    }
//
//    public String getIp() {
//        return ip;
//    }
//
//    public void setIp(String ip) {
//        this.ip = ip;
//    }
//
//    public int getPort() {
//        return port;
//    }
//
//    public void setPort(int port) {
//        this.port = port;
//    }
//
//    public String getUser() {
//        return user;
//    }
//
//    public void setUser(String user) {
//        this.user = user;
//    }
//
//    public String getPwd() {
//        return pwd;
//    }
//
//    public void setPwd(String pwd) {
//        this.pwd = pwd;
//    }
//
//
//}
