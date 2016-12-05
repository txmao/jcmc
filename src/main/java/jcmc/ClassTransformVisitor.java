package jcmc;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

class ClassTransformVisitor extends ClassVisitor implements Opcodes {
	
	String cname;

    public ClassTransformVisitor(final ClassVisitor cv) {
        super(ASM5, cv);
    }
    
    //Added to get the class name.
    @Override
    public void visit(int version, int access, String name, String signature,
			String superName, String[] interfaces) {
    	this.cname=name;
    	super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(final int access, final String name,
            final String desc, final String signature, final String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        return mv == null ? null : new MethodTransformVisitor(mv, name, cname);
    }
}


