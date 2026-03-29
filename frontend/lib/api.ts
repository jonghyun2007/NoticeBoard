const BASE_URL = "http://localhost:8080/api";

export const userApi = {
    register: async (identifier: string, email: string, password: string) => {
        const res = await fetch(`${BASE_URL}/users/register`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ identifier, email, password }),
        });

        if (!res.ok) throw new Error("회원가입 실패");
        return res.json();
    },

    login: async (identifier: string, password: string) => {
        const res = await fetch(`${BASE_URL}/users/login`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ identifier, password }),
        });

        if (!res.ok) throw new Error("로그인 실패");
        return res.json();
    },
};