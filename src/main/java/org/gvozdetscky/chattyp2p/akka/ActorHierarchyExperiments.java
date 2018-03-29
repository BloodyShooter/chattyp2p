package org.gvozdetscky.chattyp2p.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.io.IOException;

public class ActorHierarchyExperiments {

	public static void main(String[] args) throws IOException {
		ActorSystem system = ActorSystem.create("testsystem");

		ActorRef firstRef = system.actorOf(Props.create(PrintMyActorRefActor.class, "first-actor"));
		System.out.println("First: " + firstRef);
		firstRef.tell("printit", ActorRef.noSender());

		System.out.println(">>> Press ENTER to exit");
		try {
			System.in.read();
		} finally {
			system.terminate();
		}
	}
}
