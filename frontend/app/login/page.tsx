"use client";

import {useState} from "react";
import {useRouter} from "next/navigation";
import {userApi} from "@/lib/api";

export default function LoginPage() {
    const router = useRouter();
    const [identifier, setIdentifier] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = async (event: React.FormEvent) => {
        event.preventDefault();
        try {
            await userApi.login(identifier, password);
            alert("로그인에 성공했습니다.");
            router.push("/");
        } catch (error) {
            alert("로그인에 실패했습니다.");
        }
    }

    return (
        <main className="min-h-screen bg-gray-50 flex flex-col items-center justify-center px-4">
            <div className="bg-white rounded-2xl shadow-sm border border-gray-100 p-10 max-w-md w-full">
                <h1 className="text-2xl font-semibold text-gray-800 mb-1">로그인</h1>
                <p className="text-gray-400 text-sm mb-8">계정에 로그인하세요</p>

                <form onSubmit={handleSubmit} className="flex flex-col gap-4">
                    <div className="flex flex-col gap-1">
                        <label className="text-sm text-gray-600">아이디</label>
                        <input
                            type="text"
                            placeholder="아이디를 입력하세요"
                            value={identifier}
                            onChange={(e) => setIdentifier(e.target.value)}
                            className="border border-gray-200 rounded-lg px-4 py-3 text-sm text-gray-900 outline-none focus:border-blue-400 transition"                        />
                    </div>

                    <div className="flex flex-col gap-1">
                        <label className="text-sm text-gray-600">비밀번호</label>
                        <input
                            type="password"
                            placeholder="비밀번호를 입력하세요"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            className="border border-gray-200 rounded-lg px-4 py-3 text-sm text-gray-900 outline-none focus:border-blue-400 transition"                        />
                    </div>

                    <button
                        type="submit"
                        className="bg-blue-600 text-white rounded-lg py-3 text-sm font-medium hover:bg-blue-700 transition mt-2"
                    >
                        로그인
                    </button>
                </form>

                <p className="text-center text-sm text-gray-400 mt-6">
                    아직 계정이 없으신가요?{" "}
                    <a href="/register" className="text-blue-500 hover:underline">
                        회원가입
                    </a>
                </p>
            </div>
        </main>
    );
}