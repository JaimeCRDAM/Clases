// dllmain.cpp : Define el punto de entrada de la aplicación DLL.
#include "pch.h"
#include <map>

int main() {
    std::map<int, const char*> map;

    map[0] = "lmao";
    map[1] = "lmao2";
    map[3] = "lmao3";

    const char* m = map[1];

    return 0;
}

BOOL APIENTRY DllMain( HMODULE hModule,
                       DWORD  ul_reason_for_call,
                       LPVOID lpReserved
                     )
{
    switch (ul_reason_for_call)
    {
    case DLL_PROCESS_ATTACH:
        main();
    case DLL_THREAD_ATTACH:
    case DLL_THREAD_DETACH:
    case DLL_PROCESS_DETACH:
        break;
    }
    return TRUE;
}

