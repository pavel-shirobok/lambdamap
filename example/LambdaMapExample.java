/*
 * Copyright (c) 2013, Shirobok Pavel (ramshteks@gmail.com)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the <organization> nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import com.ramshteks.lambda.LambdaMap;

public class LambdaMapExample {
	public static void main(String[] args){

		new LambdaMapExample();


	}

	public interface RunnableMethod{
		void run();
	}

	public interface ReturnableMethod{
		int run(int x);
	}

	public LambdaMapExample() {
		//simple run lambda
		LambdaMap<String, RunnableMethod> lm = new LambdaMap<>();

		lm.add("test", this::test);
		lm.add("test2", this::test2);

		lm.get("test2").run();
		lm.get("test").run();

		//using default
		LambdaMap<String, ReturnableMethod> lm2 = new LambdaMap<>((int x)-> x);
		lm2.add("2", this::pow);
		lm2.add("3", this::pow3);

		System.out.println("res: " + lm2.get("2").run(2));
		System.out.println("res: " + lm2.get("4").run(2));
	}

	public int pow(int x){
		return x*x;
	}

	public int pow3(int x){
		return x*x*x;
	}

	public void test(){
		System.out.println("test");
	}

	public void test2(){
		System.out.println("test2");
	}
}
