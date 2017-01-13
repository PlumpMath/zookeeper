package com.zootutorial.app;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class ReadZNode {
	
	private static ZooKeeper zk;
	
	private static ZkConnector zkc;
	
	public static byte[] read(String path) throws KeeperException,InterruptedException{
		return zk.getData(path, true, zk.exists(path, true));
	}

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException{
		String path = "/sampleznode";
		byte[] data;
		
		zkc= new ZkConnector();
		
//		zk = zkc.connect("localhost");		//local 立加
		zk = zkc.connect("192.168.0.51:2183");		//盔拜瘤 立加
		
		data = read(path);
		
		for(byte b : data){
			System.out.print((char)b);
		}
		
		
	}
}
