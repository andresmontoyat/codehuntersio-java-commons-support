package io.codehunters.commons.util.hashids;

import org.hashids.Hashids;

public class HashId {

    private Hashids hashids;

    public HashId(String salt) {
        this.hashids = new Hashids(salt);
    }

    public HashId(String salt, int minHashLength) {
        this.hashids = new Hashids(salt, minHashLength);
    }

    public String encode() {
        return this.hashids.encode(System.currentTimeMillis());
    }

    public String encode(long...ids) {
        return this.hashids.encode(ids);
    }

    public long[] decode(String hash) {
        return this.hashids.decode(hash);
    }
}
