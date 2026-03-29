export default function Home() {
    return (
        <main className="min-h-screen bg-gray-50 flex flex-col items-center justify-center px-4">
            <div className="bg-white rounded-2xl shadow-sm border border-gray-100 p-10 max-w-md w-full text-center">
                <h1 className="text-3xl font-semibold text-gray-800 mb-2">게시판</h1>
                <p className="text-gray-400 text-sm mb-8">아무래도 첫 Spring 플젝? 연습?</p>

                <div className="flex flex-col gap-3">

                    <a
                        href="/register"
                        className="bg-blue-600 text-white rounded-lg py-3 text-sm font-medium hover:bg-blue-700 transition"
                    >
                        회원가입
                    </a>
                    <a
                        href="/login"
                        className="border border-gray-200 text-gray-600 rounded-lg py-3 text-sm font-medium hover:bg-gray-50
                    transition"
                    >
                        로그인
                    </a>
                </div>
            </div>
        </main>
    );
}