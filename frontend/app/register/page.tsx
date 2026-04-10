"use client";

import {useState} from "react";
import {useRouter} from "next/navigation";
import {userApi} from "@/lib/api";

export default function RegisterPage() {
    const router = useRouter();
    const [identifier, setIdentifier] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [passwordCheck, setPasswordCheck] = useState("");
    const [error, setError] = useState("");

    const handleSubmit = async (event: React.FormEvent) => {
        event.preventDefault();
        setError("");

        if (password !== passwordCheck) {
            setError("비밀번호가 일치하지 않습니다.");
            return;
        }

        try {
            await userApi.register(identifier, email, password);
            alert("회원가입이 완료되었습니다.")
            router.push("/login")
        } catch (error) {
            alert(error instanceof Error ? error.message : "회원가입에 실패했습니다.");
        }
    };

    return (
        <main className="min-h-screen bg-gray-50 flex flex-col items-center justify-center px-4">
            <div className="bg-white rounded-2xl shadow-sm border border-gray-100 p-10 max-w-md w-full">
                <h1 className="text-2xl font-semibold text-gray-800 mb-1">회원가입</h1>
                <p className="text-gray-400 text-sm mb-8">계정을 만들어보세요</p>

                {error && (
                    <p className="text-red-500 text-sm mb-4">{error}</p>
                )}

                <form onSubmit={handleSubmit} className="flex flex-col gap-4">
                    <div className="flex flex-col gap-1">
                        <label className="text-sm text-gray-600">아이디</label>
                        <input
                            type="text"
                            placeholder="아이디를 입력하세요"
                            value={identifier}
                            onChange={e => setIdentifier(e.target.value)}
                            className="border border-gray-200 rounded-lg px-4 py-3 text-sm text-gray-900 outline-none focus:border-blue-400 transition"/>
                    </div>

                    <div className="flex flex-col gap-1">
                        <label className="text-sm text-gray-600">이메일</label>
                        <input
                            type="email"
                            placeholder="이메일을 입력하세요"
                            value={email}
                            onChange={e => setEmail(e.target.value)}
                            className="border border-gray-200 rounded-lg px-4 py-3 text-sm text-gray-900 outline-none focus:border-blue-400 transition"/>
                    </div>

                    <div className="flex flex-col gap-1">
                        <label className="text-sm text-gray-600">비밀번호</label>
                        <input
                            type="password"
                            placeholder="비밀번호를 입력하세요"
                            value={password}
                            onChange={e => setPassword(e.target.value)}
                            className="border border-gray-200 rounded-lg px-4 py-3 text-sm text-gray-900 outline-none focus:border-blue-400 transition"/>
                    </div>

                    <div className="flex flex-col gap-1">
                        <label className="text-sm text-gray-600">비밀번호 확인</label>
                        <input
                            type="password"
                            placeholder="비밀번호를 다시 입력하세요"
                            value={passwordCheck}
                            onChange={e => setPasswordCheck(e.target.value)}
                            className="border border-gray-200 rounded-lg px-4 py-3 text-sm text-gray-900 outline-none focus:border-blue-400 transition"/>
                    </div>

                    <button
                        type="submit"
                        className="bg-blue-600 text-white rounded-lg py-3 text-sm font-medium hover:bg-blue-700 transition mt-2"
                    >
                        가입하기
                    </button>
                </form>

                <p className="text-center text-sm text-gray-400 mt-6">
                    이미 계정이 있으신가요?{" "}
                    <a href="/login" className="text-blue-500 hover:underline">
                        로그인
                    </a>
                </p>
            </div>
        </main>
    );
}