package com.zootutorial.app;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class DeleteZNode {
	
	private static ZooKeeper zk;
	
	private static ZkConnector zkc;
	
	public static void delete(String path) throws KeeperException,InterruptedException{
		zk.delete(path, zk.exists(path, true).getVersion()); //해당경로에 존재하는지 확인 후 삭제
		System.out.println(path+"  : delete complete.");
	}

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException{
		String path = "/sampleznode";
		
		zkc= new ZkConnector();
		
		zk = zkc.connect("localhost");
		
		delete(path);
	}
}
