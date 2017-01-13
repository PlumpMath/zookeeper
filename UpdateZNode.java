package com.zootutorial.app;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class UpdateZNode {

	private static ZooKeeper zk;
	
	private static ZkConnector zkc;
	
	public static void update(String path, byte[] data) throws KeeperException,InterruptedException{
		zk.setData(path, data, zk.exists(path, true).getVersion());  // data를 변경하면 version 관리를 위해서 version up을 함
	}
	
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
	
		String path="/sampleznode";
		byte[] data = "change data!".getBytes();
		
		zkc = new ZkConnector();
		
		zk = zkc.connect("localhost");
		
		update(path,data);
		
		System.out.println("updated successfully!");
	}

}
