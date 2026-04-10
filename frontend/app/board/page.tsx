"use client";

import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";

interface Board {
    id: number;
    name: string;
    author: string;
    contents: string;
    createdAt: string;
    commentCount: number;
}

export default function BoardPage() {
    const router = useRouter();
    const [boards, setBoards] = useState<Board[]>([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/boards", {
            credentials: "include",
        })
            .then((res) => {
                if (res.status === 401) {
                    router.push("/login");
                    return null;
                }
                return res.json();
            })
            .then((data) => {
                if (data) setBoards(data);
            });
    }, []);

    return (
        <main className="min-h-screen bg-gray-50 px-4 py-10">
            <div className="max-w-2xl mx-auto">
                <div className="flex justify-between items-center mb-6">
                    <h1 className="text-2xl font-semibold text-gray-800">게시판</h1>
                    <button
                        onClick={() => router.push("/board/new")}
                        className="bg-blue-600 text-white rounded-lg px-4 py-2 text-sm font-medium hover:bg-blue-700 transition"
                    >
                        글 작성
                    </button>
                </div>

                <div className="flex flex-col gap-3">
                    {boards.length === 0 ? (
                        <p className="text-center text-gray-400 text-sm py-10">
                            게시글이 없습니다.
                        </p>
                    ) : (
                        boards.map((board) => (
                            <div
                                key={board.id}
                                onClick={() => router.push(`/board/${board.id}`)}
                                className="bg-white rounded-xl border border-gray-100 p-5 hover:border-blue-200 transition cursor-pointer"
                            >
                                <div className="flex justify-between items-start">
                                    <h2 className="text-sm font-medium text-gray-800">{board.name}</h2>
                                    <span className="text-xs text-gray-400">💬 {board.commentCount}</span>
                                </div>
                                <p className="text-xs text-gray-400 mt-1">
                                    {board.author} · {new Date(board.createdAt).toLocaleDateString()}
                                </p>
                            </div>
                        ))
                    )}
                </div>
            </div>
        </main>
    );
}