package jcmc;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.*;

import java.util.*;


class MethodTransformVisitor extends MethodVisitor implements Opcodes {

	String mName;
	String cName;
	
	public static List<Integer> t_list = new ArrayList<Integer>();
	
    public MethodTransformVisitor(final MethodVisitor mv, String name, String cname) {
        super(ASM5, mv);
        this.mName=name;
        this.cName=cname;
        mv.visitEnd();
    }
    
    
    @Override
    public void visitCode(){
    	
    	
    	String m = "main"; //mark the main method
    	
    	if (mName.equals(m)) {
    		Label l0 = new Label();
    		Label l1 = new Label();
    		Label l2 = new Label();
    		mv.visitTryCatchBlock(l0, l1, l2, "java/lang/Exception");
    		mv.visitLabel(l0);
    		mv.visitInsn(ACONST_NULL);
    		mv.visitVarInsn(ASTORE, 1);
    		mv.visitInsn(ACONST_NULL);
    		mv.visitVarInsn(ASTORE, 2);
    		mv.visitTypeInsn(NEW, "java/io/FileOutputStream");
    		mv.visitInsn(DUP);
    		mv.visitLdcInsn("/home/mdy/workspace/Z_coverage/c_path.txt");
    		mv.visitInsn(ICONST_1);
    		mv.visitMethodInsn(INVOKESPECIAL, "java/io/FileOutputStream", "<init>", "(Ljava/lang/String;Z)V", false);
    		mv.visitVarInsn(ASTORE, 1);
    		mv.visitTypeInsn(NEW, "java/io/PrintStream");
    		mv.visitInsn(DUP);
    		mv.visitVarInsn(ALOAD, 1);
    		mv.visitMethodInsn(INVOKESPECIAL, "java/io/PrintStream", "<init>", "(Ljava/io/OutputStream;)V", false);
    		mv.visitVarInsn(ASTORE, 2);
    		mv.visitVarInsn(ALOAD, 2);
    		mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "setOut", "(Ljava/io/PrintStream;)V", false);
    		mv.visitLabel(l1);
    		Label l3 = new Label();
    		mv.visitJumpInsn(GOTO, l3);
    		mv.visitLabel(l2);
    		mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[] {"java/lang/Exception"});
    		mv.visitVarInsn(ASTORE, 1);
    		mv.visitVarInsn(ALOAD, 1);
    		mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Exception", "printStackTrace", "()V", false);
    		mv.visitLabel(l3);
    		mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
    	}
    	
    	String init = "<init>";
    	
    	if ( (!mName.equals(m)) ) {
    		Label l0 = new Label();
    		Label l1 = new Label();
    		Label l2 = new Label();
    		mv.visitTryCatchBlock(l0, l1, l2, "java/lang/Exception");
    		mv.visitLabel(l0);
    		mv.visitInsn(ACONST_NULL);
    		mv.visitVarInsn(ASTORE, 3);
    		mv.visitInsn(ACONST_NULL);
    		mv.visitVarInsn(ASTORE, 4);
    		mv.visitTypeInsn(NEW, "java/io/FileOutputStream");
    		mv.visitInsn(DUP);
    		mv.visitLdcInsn("/home/mdy/workspace/Z_coverage/c_path.txt");
    		mv.visitInsn(ICONST_1);
    		mv.visitMethodInsn(INVOKESPECIAL, "java/io/FileOutputStream", "<init>", "(Ljava/lang/String;Z)V", false);
    		mv.visitVarInsn(ASTORE, 3);
    		mv.visitTypeInsn(NEW, "java/io/PrintStream");
    		mv.visitInsn(DUP);
    		mv.visitVarInsn(ALOAD, 3);
    		mv.visitMethodInsn(INVOKESPECIAL, "java/io/PrintStream", "<init>", "(Ljava/io/OutputStream;)V", false);
    		mv.visitVarInsn(ASTORE, 4);
    		mv.visitVarInsn(ALOAD, 4);
    		mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "setOut", "(Ljava/io/PrintStream;)V", false);
    		mv.visitLabel(l1);
    		Label l3 = new Label();
    		mv.visitJumpInsn(GOTO, l3);
    		mv.visitLabel(l2);
    		mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[] {"java/lang/Exception"});
    		mv.visitVarInsn(ASTORE, 3);
    		mv.visitVarInsn(ALOAD, 3);
    		mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Exception", "printStackTrace", "()V", false);
    		mv.visitLabel(l3);
    		mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
    	}
    	
    	/*
    	mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
    	mv.visitLdcInsn(mName+" executed...");
    	mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
    	*/
    	
    	super.visitCode();
    }
    
    
    //Edit By Dongyu Mao DXM162530
    @Override
    public void visitLineNumber(int line, Label start) {
    	
    	System.out.println(cName+"-"+line);
    	
    	//////------write the total lines related to t_path file------------
    	t_list.add(line);
//        System.out.println(cName+t_list.toString());
    	try{
			String t_path = "/home/mdy/workspace/Z_coverage/t_path.txt";
			BufferedWriter t_br = new BufferedWriter(new FileWriter(t_path, true));
			//t_br.write(t_list.toString());
//			for (int i=0; i<t_list.size(); i++) {
//				t_br.write(cName+"-"+t_list.get(i).toString());
//				t_br.write("\n");
//			}
			t_br.write(cName+"-"+line);
			t_br.write("\n");
			t_br.flush();
			t_br.close();
		} catch (Exception e) {
			e.printStackTrace();;
		}
    	//////----------------------------------------------------------------
    	
    	mv.visitLineNumber(line, start);
    	mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
    	mv.visitLdcInsn(cName+"-"+line);
    	mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
    	super.visitLineNumber(line, start);
    }
    
}