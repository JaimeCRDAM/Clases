union std_string_union
{
	char _Buf[16];
	char* _Ptr;
};

struct std_string
{
	
	union std_string_union u;
	size_t _Mysize;
	size_t _Myres;
	
};