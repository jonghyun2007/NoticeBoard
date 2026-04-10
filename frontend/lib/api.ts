const BASE_URL = "http://localhost:8080/api";

export const userApi = {
    register: async (identifier: string, email: string, password: string) => {
        const res = await fetch(`${BASE_URL}/users/register`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            credentials: "include",
            body: JSON.stringify({ identifier, email, password }),
        });
        if (!res.ok) {
            const data = await res.json();
            throw new Error(data.message);
        }
        return res.json();
    },

    login: async (identifier: string, password: string) => {
        const res = await fetch(`${BASE_URL}/users/login`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            credentials: "include",
            body: JSON.stringify({ identifier, password }),
        });
        if (!res.ok) {
            const data = await res.json();
            throw new Error(data.message);
        }
    },

    me: async () => {
        const res = await fetch(`${BASE_URL}/users/me`, {
            credentials: "include",
        });
        if (!res.ok) throw new Error("인증 실패");
        return res.json();
    },

    logout: async () => {
        await fetch(`${BASE_URL}/users/logout`, {
            method: "POST",
            credentials: "include",
        });
    },
};