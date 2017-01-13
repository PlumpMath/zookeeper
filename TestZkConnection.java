package com.zootutorial.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class TestZkConnection {

	private static ZooKeeper zk;
	
	private static ZkConnector zkc;
	
	private static List<String> znodeList = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException, InterruptedException,KeeperException{
		
		zkc = new ZkConnector();
		zk = zkc.connect("192.68.0.51:2183");
		znodeList = zk.getChildren("/", true);
		
		if(znodeList == null){
			System.out.println("znodeList is null");
		}
		for(String znode : znodeList){
			System.out.println(znode);
		}
	}
}
