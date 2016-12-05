package jcmc;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.security.ProtectionDomain;

public class Agent {
	public static void premain(String agentArgs, Instrumentation inst) {
		inst.addTransformer(new ClassFileTransformer() {
			public byte[] transform(ClassLoader l,
					                String name,
					                Class<?> c,
					                ProtectionDomain d, byte[] b) throws IllegalClassFormatException {
				/*
				if (!(name.equals("t") || name.equals("t1"))){
					return null;
				}
				*/
				if (!name.startsWith(agentArgs)) {
					return null;
				}
				ClassReader cr = new ClassReader(b);
				ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
				ClassTransformVisitor ca = new ClassTransformVisitor(cw);
				cr.accept(ca, 0);
				return cw.toByteArray();
			}
		});
	}
}

